package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.entity.BusStopMasterEntity;
import com.busservice.BusService.entity.PassTypeMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.PassTypeMasterRepo;
import com.busservice.BusService.request.PassTypeMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.BusStopMasterReponse;
import com.busservice.BusService.response.PassTypeMasterReponse;
import com.busservice.BusService.service.PassTypeMasterService;
import com.busservice.BusService.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PassTypeMasterServiceImpl implements PassTypeMasterService {

    @Autowired
    private PassTypeMasterRepo passTypeMasterRepo;


    @Override
    public BusPassResponse savePassTypeMaster(PassTypeMasterCreateRequest masterCreateRequest) {
        Optional<BusStopMasterEntity> optionalDepartmentEntity = passTypeMasterRepo.findByPassTypeNameEqualsIgnoreCase(masterCreateRequest.getPassTypeName());
        if (optionalDepartmentEntity.isPresent()) {
            log.error("Inside PassTypeMasterServiceImpl >> saveBusStopMaster()");
            throw new BusPassException("PassTypeMasterServiceImpl Class", false, "Routes name already exist");
        }

        PassTypeMasterEntity passTypeMasterEntity = convertPassTypeMasterCreateRequestToEntity(masterCreateRequest);
        try {
            passTypeMasterRepo.save(passTypeMasterEntity);
            return BusPassResponse.builder()
                    .isSuccess(true)
                    .responseMessage(BusPassConstant.RECORD_SUCCESS)
                    .build();
        } catch (Exception ex) {
            log.error("Inside PassTypeMasterServiceImpl >> savePassTypeMaster(): {}",ex);
            throw new BusPassException("PassTypeMasterServiceImpl", false, ex.getMessage());
        }
    }

    @Override
    public BusPassResponse findPassTypeMasterDetails(Integer busStopId, String busStopName, String statusCd, Pageable requestPageable) {
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

            Integer totalCount = passTypeMasterRepo.getPassTypeMasterDetailsCount(busStopId, busStopName, statusCd);
            List<Object[]> passTypeMasterData = passTypeMasterRepo.getPassTypeMasterDetail(busStopId, busStopName, statusCd, sortName, pageSize, pageOffset);
            List<PassTypeMasterReponse> passTypeMasterReponses = passTypeMasterData.stream().map(PassTypeMasterReponse::new).collect(Collectors.toList());
            if (passTypeMasterReponses.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(passTypeMasterReponses, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("PassTypeMasterServiceImpl >> findPassTypeMasterDetails : {}", ex);
            throw new BusPassException("PassTypeMasterServiceImpl", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .isSuccess(false)
                .build();
    }

    @Transactional
    @Override
    public BusPassResponse deletePassTypeMasterDetails(Integer busStopId) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            passTypeMasterRepo.deletePassTypeMasterDetails(busStopId);
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Bus Stop details deleted Successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside PassTypeMasterServiceImpl >> deletePassTypeMasterDetails : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }

    }



    private PassTypeMasterEntity convertPassTypeMasterCreateRequestToEntity(PassTypeMasterCreateRequest passTypeMasterCreateRequest) {
        PassTypeMasterEntity passTypeMasterEntity = new PassTypeMasterEntity();

        passTypeMasterEntity.setPassTypeName(passTypeMasterCreateRequest.getPassTypeName());
        passTypeMasterEntity.setPassTypeDescription(passTypeMasterCreateRequest.getPassTypeDescription());
        passTypeMasterEntity.setPassTypeEndDate(DateTimeUtils.convertStringToInstant(passTypeMasterCreateRequest.getPassTypeEndDate()));
        passTypeMasterEntity.setPassTypeCollectionLocation(passTypeMasterCreateRequest.getPassTypeCollectionLocation());
        passTypeMasterEntity.setPassTypeAmount(passTypeMasterCreateRequest.getPassTypeAmount());
        passTypeMasterEntity.setPassTypeAgeLimit(passTypeMasterCreateRequest.getPassTypeAgeLimit());
        passTypeMasterEntity.setRemark(passTypeMasterCreateRequest.getRemark());
        passTypeMasterEntity.setStatusCd(passTypeMasterCreateRequest.getStatusCd());
        passTypeMasterEntity.setCreatedUserId(passTypeMasterCreateRequest.getEmployeeId());
        return passTypeMasterEntity;
    }
}
