package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.entity.StudentPassMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.StudentPassMasterRepo;
import com.busservice.BusService.request.StudentPassMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.StudentPassMasterReponse;
import com.busservice.BusService.response.dropdown.PassTypeMasterDD;
import com.busservice.BusService.service.StudentPassMasterService;
import com.busservice.BusService.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentPassMasterServiceImpl implements StudentPassMasterService {

    @Autowired
    private StudentPassMasterRepo studentPassMasterRepo;


    @Override
    public BusPassResponse saveStudentPassMaster(StudentPassMasterCreateRequest masterCreateRequest) {
        /*Optional<BusStopMasterEntity> optionalDepartmentEntity = studentPassMasterRepo.findByBusStopNameEqualsIgnoreCase(masterCreateRequest.getBusStopName());
        if (optionalDepartmentEntity.isPresent()) {
            log.error("Inside StudentPassMasterServiceImpl >> saveStudentPassMaster()");
            throw new BusPassException("StudentPassMasterServiceImpl Class", false, "Student Pass already exist");
        }*/

        StudentPassMasterEntity busStopMasterEntity = convertStudentPassMasterCreateRequestToEntity(masterCreateRequest);
        try {
            studentPassMasterRepo.save(busStopMasterEntity);
            return BusPassResponse.builder()
                    .isSuccess(true)
                    .responseMessage(BusPassConstant.RECORD_SUCCESS)
                    .build();
        } catch (Exception ex) {
            log.error("Inside StudentPassMasterServiceImpl >> saveStudentPassMaster() : {}", ex);
            throw new BusPassException("StudentPassMasterServiceImpl", false, ex.getMessage());
        }
    }

    @Override
    public BusPassResponse findStudentPassMasterDetails(Integer studPassId, String studPassStatus, String statusCd, Pageable requestPageable) {
        try {
            String sortName = null;
            //  String sortDirection = null;
            Integer pageSize = requestPageable.getPageSize();
            Integer pageOffset = (int) requestPageable.getOffset();
            // pageable = KPIUtils.sort(requestPageable, sortParam, pageDirection);
            Optional<Sort.Order> order = requestPageable.getSort().get().findFirst();
            if (order.isPresent()) {
                sortName = order.get().getProperty();  //order by this field
                //sortDirection = order.get().getDirection().toString(); // Sort ASC or DESC
            }

            Integer totalCount = studentPassMasterRepo.getStudentPassMasterDetailsCount(studPassId, studPassStatus, statusCd);
            List<Object[]> studentPassMasterData = studentPassMasterRepo.getStudentPassMasterDetail(studPassId, studPassStatus, statusCd, sortName, pageSize, pageOffset);
            List<StudentPassMasterReponse> studentPassMasterReponses = studentPassMasterData.stream().map(StudentPassMasterReponse::new).collect(Collectors.toList());
            if (studentPassMasterReponses.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(studentPassMasterReponses, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("StudentPassMasterServiceImpl >> findStudentPassMasterDetails : {}", ex);
            throw new BusPassException("StudentPassMasterServiceImpl", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .isSuccess(false)
                .build();
    }


    @Override
    public StudentPassMasterReponse findStudentPassMasterDetailsByStudPassId(Integer studPassId) {
        try {
            List<Object[]> studentPassMasterData = studentPassMasterRepo.getStudentPassMasterDetailById(studPassId);
            List<StudentPassMasterReponse> studentPassMasterReponses = studentPassMasterData.stream().map(StudentPassMasterReponse::new).collect(Collectors.toList());
            if (studentPassMasterReponses.size() > 0) {
               return studentPassMasterReponses.get(0);
            }
        } catch (Exception ex) {
            log.error("StudentPassMasterServiceImpl >> findStudentPassMasterDetails : {}", ex);
            throw new BusPassException("StudentPassMasterServiceImpl", false, ex.getMessage());
        }
        return null;
    }


    @Transactional
    @Override
    public BusPassResponse deleteStudentPassMasterDetails(Integer studPassId) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            studentPassMasterRepo.deleteStudentPassMasterDetails(studPassId);
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Student Pass details deleted Successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside StudentPassMasterServiceImpl >> deleteStudentPassMasterDetails : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }

    }



    private StudentPassMasterEntity convertStudentPassMasterCreateRequestToEntity(StudentPassMasterCreateRequest masterCreateRequest) {

        //pass start date, pass expire date and Payment status need to be update
        StudentPassMasterEntity studentPassMasterEntity = new StudentPassMasterEntity();
        studentPassMasterEntity.setCustId(masterCreateRequest.getCustId());
        studentPassMasterEntity.setPassTypeId(masterCreateRequest.getPassTypeId());
        studentPassMasterEntity.setStudPassCreatedDate(Instant.now());
        studentPassMasterEntity.setStudPassExpiryDate(Instant.now());
        studentPassMasterEntity.setRoutesId(masterCreateRequest.getRoutesId());
        studentPassMasterEntity.setFromBusStopId(masterCreateRequest.getFromBusStopId());
        studentPassMasterEntity.setToBusStopId(masterCreateRequest.getToBusStopId());
        studentPassMasterEntity.setStudPassAmount(masterCreateRequest.getPassTypeAmount());
        studentPassMasterEntity.setStudPassAmountPaidStatus("Pending");
        studentPassMasterEntity.setSchoolId(masterCreateRequest.getSchoolId());
        studentPassMasterEntity.setSchoolIdentificationNumber(masterCreateRequest.getSchoolIdentificationNumber());
        studentPassMasterEntity.setStudCourseName(masterCreateRequest.getStudCourseName());
        studentPassMasterEntity.setStudClassName(masterCreateRequest.getStudClassName());
        studentPassMasterEntity.setStudRollNo(masterCreateRequest.getStudRollNo());
        studentPassMasterEntity.setStudPassStatus("InActive"); //Active or InActive
        studentPassMasterEntity.setRemark(masterCreateRequest.getRemark());
        studentPassMasterEntity.setStatusCd(masterCreateRequest.getStatusCd());
        studentPassMasterEntity.setCreatedUserId(masterCreateRequest.getEmployeeId());
        return studentPassMasterEntity;
    }
}

