package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.dto.DDRoutesMasterResponse;
import com.busservice.BusService.entity.LanguageMasterEntity;
import com.busservice.BusService.entity.SchoolInformationMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.LanguageMasterRepo;
import com.busservice.BusService.repository.SchoolInformationMasterRepo;
import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.request.LanguageMasterUpdateRequest;
import com.busservice.BusService.request.SchoolInformationMasterCreateRequest;
import com.busservice.BusService.request.SchoolInformationMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.LanguageMasterReponse;
import com.busservice.BusService.response.SchoolInformationMasterReponse;
import com.busservice.BusService.response.dropdown.LanguageMasterDD;
import com.busservice.BusService.response.dropdown.SchoolInfoMasterDD;
import com.busservice.BusService.service.LanguageMasterService;
import com.busservice.BusService.service.SchoolInformationMasterService;
import com.busservice.BusService.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SchoolInformationMasterServiceImpl implements SchoolInformationMasterService {

    @Autowired
    private SchoolInformationMasterRepo schoolInformationMasterRepo;

    @Value("${school-max-number}")
    private Integer schoolMaxNumber;

    @Override
    public BusPassResponse saveSchoolInformationMaster(SchoolInformationMasterCreateRequest masterCreateRequest) {
        Optional<SchoolInformationMasterEntity> optionalSchoolEntity = schoolInformationMasterRepo.findBySchoolNameEqualsIgnoreCase(masterCreateRequest.getSchoolName());
        if (optionalSchoolEntity.isPresent()) {
            log.error("Inside SchoolInformationMasterServiceImpl >> saveSchoolInformationMaster()");
            throw new BusPassException("SchoolInformationMasterServiceImpl >> saveSchoolInformationMaster", false, "Language name already exist");
        }

        SchoolInformationMasterEntity schoolInformationMasterEntity = convertSchoolInformationMasterCreateRequestToEntity(masterCreateRequest);
        try {
            schoolInformationMasterRepo.save(schoolInformationMasterEntity);

            return BusPassResponse.builder()
                    .isSuccess(true)
                    .responseMessage(BusPassConstant.RECORD_SUCCESS)
                    .build();
        } catch (Exception ex) {
            log.error("Inside SchoolInformationMasterServiceImpl >> saveSchoolInformationMaster() : {}", ex);
            throw new BusPassException("SchoolInformationMasterServiceImpl >> saveSchoolInformationMaster", false, ex.getMessage());
        }
    }

    @Transactional
    @Override
    public BusPassResponse updateSchoolInformationMaster(SchoolInformationMasterUpdateRequest masterUpdateRequest) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
        Optional<SchoolInformationMasterEntity> optionalSchoolInformationMasterEntity = schoolInformationMasterRepo.findById(masterUpdateRequest.getSchoolId());
        if(optionalSchoolInformationMasterEntity.isPresent()) {
            SchoolInformationMasterEntity schoolInformationMasterEntity = optionalSchoolInformationMasterEntity.get();
            schoolInformationMasterEntity.setSchoolName(masterUpdateRequest.getSchoolName());
            schoolInformationMasterEntity.setSchoolAddresss(masterUpdateRequest.getSchoolAddresss());
            schoolInformationMasterEntity.setSchoolAutonomus(masterUpdateRequest.getSchoolAutonomus());
            schoolInformationMasterRepo.save(schoolInformationMasterEntity);
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("School information updated successfully");
            return busPassResponse;
        }
        } catch (Exception ex) {
            log.error("Inside SchoolInformationMasterServiceImpl >> updateSchoolInformationMaster : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }
        busPassResponse.setSuccess(false);
        busPassResponse.setResponseMessage("School information Not updated successfully");
        return busPassResponse;
    }

    @Override
    public BusPassResponse findSchoolInformationMasterDetailsPaging(Integer schoolId, String schoolName,String schoolIdentificationNumber, String statusCd, Pageable requestPageable) {
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

            Integer totalCount = schoolInformationMasterRepo.getSchoolInformationrDetailCount(schoolId, schoolName,schoolIdentificationNumber ,statusCd);
            List<Object[]> languageMasterData = schoolInformationMasterRepo.getSchoolInformationrDetail(schoolId, schoolName,schoolIdentificationNumber, statusCd, sortName, pageSize, pageOffset);
            List<SchoolInformationMasterReponse> schoolInformationMasterReponses = languageMasterData.stream().map(SchoolInformationMasterReponse::new).collect(Collectors.toList());
            if (schoolInformationMasterReponses.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(schoolInformationMasterReponses, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("SchoolInformationMasterServiceImpl >>findSchoolInformationMasterDetailsPaging : {}", ex);
            throw new BusPassException("SchoolInformationMasterServiceImpl >> findSchoolInformationMasterDetailsPaging", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .isSuccess(false)
                .build();
    }

    @Override
    public SchoolInformationMasterReponse findSchoolInformationMasterBySchoolId(Integer schoolId) {
        try {
            List<Object[]> languageMasterData = schoolInformationMasterRepo.getSchoolInformationrDetailById(schoolId);
            List<SchoolInformationMasterReponse> languageMasterReponses = languageMasterData.stream().map(SchoolInformationMasterReponse::new).collect(Collectors.toList());
            if (languageMasterReponses.size() > 0) {
                return languageMasterReponses.get(0);
            }
        } catch (Exception ex) {
            log.error("SchoolInformationMasterServiceImpl >>findSchoolInformationMasterBySchoolId() : {}", ex);
            throw new BusPassException("SchoolInformationMasterServiceImpl >> findSchoolInformationMasterBySchoolId", false, ex.getMessage());
        }
        return null;
    }

    @Override
    public List<SchoolInfoMasterDD> ddSchoolInformationMasterDetails() {
        try {
            List<Object[]> schoolInformationMasterData = schoolInformationMasterRepo.ddSchoolInformationMaster();
            List<SchoolInfoMasterDD> schoolInfoMasterDDS = schoolInformationMasterData.stream().map(SchoolInfoMasterDD::new).collect(Collectors.toList());
            if (schoolInfoMasterDDS.size() > 0) {
                return schoolInfoMasterDDS;
            }
        } catch (Exception ex) {
            log.error("SchoolInformationMasterServiceImpl >> ddSchoolInformationMasterDetails : {}", ex);
            throw new BusPassException("SchoolInformationMasterServiceImpl >> ddSchoolInformationMasterDetails", false, ex.getMessage());
        }
        return null;
    }

    @Transactional
    @Override
    public BusPassResponse deleteSchoolInformationMasterById(Integer schoolId) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            schoolInformationMasterRepo.deleteLanguageMasterDetails(schoolId);
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("School Information details deleted Successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside LanguageMasterServiceImpl >> deleteLanguageMasterDetails : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }

    }




    private SchoolInformationMasterEntity convertSchoolInformationMasterCreateRequestToEntity(SchoolInformationMasterCreateRequest masterCreateRequest) {
        SchoolInformationMasterEntity schoolInformationMasterEntity = new SchoolInformationMasterEntity();

        schoolInformationMasterEntity.setSchoolIdentificationNumber("SCH"+getRandomNumber());
        schoolInformationMasterEntity.setSchoolName(masterCreateRequest.getSchoolName());
        schoolInformationMasterEntity.setSchoolAddresss(masterCreateRequest.getSchoolAddresss());
        schoolInformationMasterEntity.setSchoolAutonomus(masterCreateRequest.getSchoolAutonomus());
        schoolInformationMasterEntity.setSchoolEveryDayStartTiming(DateTimeUtils.convertStringToInstant(masterCreateRequest.getSchoolEveryDayStartTiming()));
        schoolInformationMasterEntity.setSchoolEveryDayEndTiming(DateTimeUtils.convertStringToInstant(masterCreateRequest.getSchoolEveryDayEndTiming()));



        schoolInformationMasterEntity.setRemark(masterCreateRequest.getRemark());
        schoolInformationMasterEntity.setStatusCd(masterCreateRequest.getStatusCd());
        schoolInformationMasterEntity.setCreatedUserId(masterCreateRequest.getEmployeeId());
        return schoolInformationMasterEntity;
    }

    private Integer getRandomNumber() {
        return (int) (Math.random() * schoolMaxNumber);
    }
}
