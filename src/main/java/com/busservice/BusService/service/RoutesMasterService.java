package com.busservice.BusService.service;

import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.request.RoutesMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import org.springframework.data.domain.Pageable;

public interface RoutesMasterService {

    public BusPassResponse saveRoutesMaster(RoutesMasterCreateRequest routesMasterCreateRequest);

    public BusPassResponse findRoutesMasterDetails(Integer routesId, String routesName, String statusCd, Pageable pageable);

    public BusPassResponse deleteRoutesMasterDetails(Integer routesId);



}
