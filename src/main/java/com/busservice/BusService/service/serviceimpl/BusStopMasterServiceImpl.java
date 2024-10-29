package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.response.dropdown.BusStopMasterDD;
import com.busservice.BusService.response.dropdown.RoutesMasterDD;
import com.busservice.BusService.entity.BusStopMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.BusStopMasterRepo;
import com.busservice.BusService.request.BusStopMasterCreateRequest;
import com.busservice.BusService.request.BusStopMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.BusStopMasterReponse;
import com.busservice.BusService.response.dropdown.SchoolInfoMasterDD;
import com.busservice.BusService.service.BusStopMasterService;
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
public class BusStopMasterServiceImpl implements BusStopMasterService {

    @Autowired
    private BusStopMasterRepo busStopMasterRepo;


    @Override
    public BusPassResponse saveBusStopMaster(BusStopMasterCreateRequest masterCreateRequest) {
        Optional<BusStopMasterEntity> optionalDepartmentEntity = busStopMasterRepo.findByBusStopNameEqualsIgnoreCase(masterCreateRequest.getBusStopName());
        if (optionalDepartmentEntity.isPresent()) {
            log.error("Inside BusStopMasterServiceImpl >> saveBusStopMaster()");
            throw new BusPassException("BusStopMasterServiceImpl Class", false, "Routes name already exist");
        }

        BusStopMasterEntity busStopMasterEntity = convertBusStopMasterCreateRequestToEntity(masterCreateRequest);
        try {
            busStopMasterRepo.save(busStopMasterEntity);
            return BusPassResponse.builder()
                    .isSuccess(true)
                    .responseMessage(BusPassConstant.RECORD_SUCCESS)
                    .build();
        } catch (Exception ex) {
            log.error("Inside BusStopMasterServiceImpl >> saveBusStopMaster() : {}",ex);
            throw new BusPassException("BusStopMasterServiceImpl", false, ex.getMessage());
        }
    }


    @Transactional
    @Override
    public BusPassResponse updateBusStopMaster(BusStopMasterUpdateRequest masterUpdateRequest) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            Optional<BusStopMasterEntity> optionalBusStopMasterEntity = busStopMasterRepo.findById(masterUpdateRequest.getBusStopId());
            if(optionalBusStopMasterEntity.isPresent()) {
                BusStopMasterEntity busStopMasterEntity = optionalBusStopMasterEntity.get();
                busStopMasterEntity.setBusStopName(masterUpdateRequest.getBusStopName());
                busStopMasterEntity.setBusStopNo(masterUpdateRequest.getBusStopNo());
                busStopMasterRepo.save(busStopMasterEntity);
            return BusPassResponse.builder()
                    .isSuccess(true)
                    .responseMessage(BusPassConstant.RECORD_SUCCESS)
                    .build();
        }} catch (Exception ex) {
            log.error("Inside BusStopMasterServiceImpl >> updateBusStopMaster() : {}", ex);
            throw new BusPassException("BusStopMasterServiceImpl>>updateBusStopMaster", false, ex.getMessage());
        }
        return null;
    }

    @Override
    public List<BusStopMasterDD> ddBusStopMasterDetails(Integer routesId) {
        try {
            List<Object[]> busStopMasterData = busStopMasterRepo.ddBusStopMaster(routesId);
            List<BusStopMasterDD> busStopMasterDDS = busStopMasterData.stream().map(BusStopMasterDD::new).collect(Collectors.toList());
            if (busStopMasterDDS.size() > 0) {
                return busStopMasterDDS;
            }
        } catch (Exception ex) {
            log.error("BusStopMasterServiceImpl >> ddBusStopMasterDetails : {}", ex);
            throw new BusPassException("BusStopMasterServiceImpl >> ddBusStopMasterDetails", false, ex.getMessage());
        }
        return null;
    }
    @Override
    public BusPassResponse findBusStopMasterDetails(Integer busStopId, String busStopName, String statusCd, Pageable requestPageable) {
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

            Integer totalCount = busStopMasterRepo.getBusStopMasterDetailsCount(busStopId, busStopName, statusCd);
            List<Object[]> languageMasterData = busStopMasterRepo.getBusStopMasterDetail(busStopId, busStopName, statusCd, sortName, pageSize, pageOffset);
            List<BusStopMasterReponse> busStopMasterReponses = languageMasterData.stream().map(BusStopMasterReponse::new).collect(Collectors.toList());
            if (busStopMasterReponses.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(busStopMasterReponses, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("BusStopMasterServiceImpl >> findRoutesMasterDetails : {}", ex);
            throw new BusPassException("BusStopMasterServiceImpl", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .isSuccess(false)
                .build();
    }


    @Override
    public BusStopMasterReponse findBusStopMasterDetailsById(Integer busStopId) {
        try {
            List<Object[]> languageMasterData = busStopMasterRepo.getBusStopMasterDetailById(busStopId);
            List<BusStopMasterReponse> busStopMasterReponses = languageMasterData.stream().map(BusStopMasterReponse::new).collect(Collectors.toList());
            if (busStopMasterReponses.size() > 0) {
                return busStopMasterReponses.get(0);
            }
        } catch (Exception ex) {
            log.error("BusStopMasterServiceImpl >> findRoutesMasterDetails : {}", ex);
            throw new BusPassException("BusStopMasterServiceImpl", false, ex.getMessage());
        }
        return null;
    }

    @Transactional
    @Override
    public BusPassResponse deleteBusStopMasterDetails(Integer busStopId) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            busStopMasterRepo.deleteBusStopMasterDetails(busStopId);
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Bus Stop details deleted Successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside BusStopMasterServiceImpl >> deleteBusStopMasterDetails : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }

    }

    @Override
    public List<RoutesMasterDD> ddBusRoutesMasterDetails() {
        try {
            List<Object[]> languageMasterData = busStopMasterRepo.ddRouteNameFromBusStopMaster();
            List<RoutesMasterDD> busStopMasterReponses = languageMasterData.stream().map(RoutesMasterDD::new).collect(Collectors.toList());
            if (busStopMasterReponses.size() > 0) {
                return busStopMasterReponses;
            }
        } catch (Exception ex) {
            log.error("BusStopMasterServiceImpl >> findRoutesMasterDetails : {}", ex);
            throw new BusPassException("BusStopMasterServiceImpl", false, ex.getMessage());
        }
        return null;
    }


    private BusStopMasterEntity convertBusStopMasterCreateRequestToEntity(BusStopMasterCreateRequest busStopMasterCreateRequest) {
        BusStopMasterEntity busStopMasterEntity = new BusStopMasterEntity();

        busStopMasterEntity.setRoutesId(busStopMasterCreateRequest.getRoutesId());
        busStopMasterEntity.setBusStopName(busStopMasterCreateRequest.getBusStopName());
        busStopMasterEntity.setBusStopNo(busStopMasterCreateRequest.getBusStopNo());
        busStopMasterEntity.setRemark(busStopMasterCreateRequest.getRemark());
        busStopMasterEntity.setStatusCd(busStopMasterCreateRequest.getStatusCd());
        busStopMasterEntity.setCreatedUserId(busStopMasterCreateRequest.getEmployeeId());
        return busStopMasterEntity;
    }
}
