package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.response.dropdown.RoutesMasterDD;
import com.busservice.BusService.entity.RoutesMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.RoutesMasterRepo;
import com.busservice.BusService.request.RoutesMasterCreateRequest;
import com.busservice.BusService.request.RoutesMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.RoutesMasterReponse;
import com.busservice.BusService.service.RoutesMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoutesMasterServiceImpl implements RoutesMasterService {

    @Autowired
    private RoutesMasterRepo routesMasterRepo;


    @Override
    public BusPassResponse saveRoutesMaster(RoutesMasterCreateRequest masterCreateRequest) {
        Optional<RoutesMasterEntity> optionalDepartmentEntity = routesMasterRepo.findByRoutesNameEqualsIgnoreCase(masterCreateRequest.getRoutesName());
        if (optionalDepartmentEntity.isPresent()) {
            log.error("Inside RoutesMasterServiceImpl >> saveRoutesMaster()");
            throw new BusPassException("RoutesMasterServiceImpl Class", false, "Routes name already exist");
        }

        RoutesMasterEntity routesMasterEntity = convertLanguageMasterCreateRequestToEntity(masterCreateRequest);
        try {
            routesMasterRepo.save(routesMasterEntity);
            return BusPassResponse.builder()
                    .isSuccess(true)
                    .responseMessage(BusPassConstant.RECORD_SUCCESS)
                    .build();
        } catch (Exception ex) {
            log.error("Inside RoutesMasterServiceImpl >> saveRoutesMaster()");
            throw new BusPassException("RoutesMasterServiceImpl", false, ex.getMessage());
        }
    }

    @Transactional
    @Override
    public BusPassResponse updateRoutesMaster(RoutesMasterUpdateRequest masterUpdateRequest) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            routesMasterRepo.updateRoutesMasterDetails(masterUpdateRequest.getRoutesId(), masterUpdateRequest.getRoutesName(), masterUpdateRequest.getRoutesStartLocation(), masterUpdateRequest.getRoutesEndLocation(), masterUpdateRequest.getRemark(), masterUpdateRequest.getEmployeeId());
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Language updated successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside LanguageMasterServiceImpl >> updateLanguageMaster : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }
    }

    @Override
    public BusPassResponse findRoutesMasterDetails(Integer routesId, String routesName, String statusCd, Pageable requestPageable) {
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

            Integer totalCount = routesMasterRepo.getRoutesMasterDetailsCount(routesId, routesName, statusCd);
            List<Object[]> languageMasterData = routesMasterRepo.getRoutesMasterDetail(routesId, routesName, statusCd, sortName, pageSize, pageOffset);
            List<RoutesMasterReponse> routesMasterReponses = languageMasterData.stream().map(RoutesMasterReponse::new).collect(Collectors.toList());
            if (routesMasterReponses.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(routesMasterReponses, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("RoutesMasterServiceImpl >> findRoutesMasterDetails : {}", ex);
            throw new BusPassException("RoutesMasterServiceImpl", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .isSuccess(false)
                .build();
    }

    @Override
    public RoutesMasterReponse findRoutesMasterDetailsById(Integer routesId) {
        try {
            List<Object[]> languageMasterData = routesMasterRepo.getRoutesMasterDetailById(routesId);
            List<RoutesMasterReponse> routesMasterReponses = languageMasterData.stream().map(RoutesMasterReponse::new).collect(Collectors.toList());
            if (routesMasterReponses.size() > 0) {
                return routesMasterReponses.get(0);
            }
        } catch (Exception ex) {
            log.error("RoutesMasterServiceImpl >> findRoutesMasterDetailsById() : {}", ex);
            throw new BusPassException("RoutesMasterServiceImpl>> findRoutesMasterDetailsById()", false, ex.getMessage());
        }
        return null;
    }

    @Transactional
    @Override
    public BusPassResponse deleteRoutesMasterDetails(Integer routesId) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            routesMasterRepo.deleteRoutesMasterDetails(routesId);
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Routes details deleted Successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside RoutesMasterServiceImpl >> deleteRoutesMasterDetails : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }

    }

    @Override
    public List<RoutesMasterDD> ddBusRoutesMasterDetails() {
        List<RoutesMasterDD> ddRoutesMasterResponses = new ArrayList<>();
        List<RoutesMasterEntity> routesMasterEntities = routesMasterRepo.findByStatusCd("A");
        if (routesMasterEntities.size() > 0) {
            for (RoutesMasterEntity routesMasterEntity : routesMasterEntities) {
                RoutesMasterDD ddRoutesMasterResponse = new RoutesMasterDD();
                ddRoutesMasterResponse.setRoutesId(routesMasterEntity.getRoutesId());
                ddRoutesMasterResponse.setRoutesName(routesMasterEntity.getRoutesName());
                ddRoutesMasterResponses.add(ddRoutesMasterResponse);
            }
            return ddRoutesMasterResponses;
        }
        return null;
    }


    private RoutesMasterEntity convertLanguageMasterCreateRequestToEntity(RoutesMasterCreateRequest routesMasterCreateRequest) {
        RoutesMasterEntity routesMasterEntity = new RoutesMasterEntity();

        routesMasterEntity.setRoutesName(routesMasterCreateRequest.getRoutesName());
        routesMasterEntity.setRoutesStartLocation(routesMasterCreateRequest.getRoutesStartLocation());
        routesMasterEntity.setRoutesEndLocation(routesMasterCreateRequest.getRoutesEndLocation());
        routesMasterEntity.setRemark(routesMasterCreateRequest.getRemark());
        routesMasterEntity.setStatusCd(routesMasterCreateRequest.getStatusCd());
        routesMasterEntity.setCreatedUserId(routesMasterCreateRequest.getEmployeeId());
        return routesMasterEntity;
    }
}
