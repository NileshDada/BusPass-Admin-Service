package com.busservice.BusService.service;

import com.busservice.BusService.response.dropdown.RoutesMasterDD;
import com.busservice.BusService.request.RoutesMasterCreateRequest;
import com.busservice.BusService.request.RoutesMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.RoutesMasterReponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoutesMasterService {

    public BusPassResponse saveRoutesMaster(RoutesMasterCreateRequest routesMasterCreateRequest);

    public BusPassResponse updateRoutesMaster(RoutesMasterUpdateRequest masterUpdateRequest);
    public BusPassResponse findRoutesMasterDetails(Integer routesId, String routesName, String statusCd, Pageable pageable);

    public RoutesMasterReponse findRoutesMasterDetailsById(Integer routesId);

    public BusPassResponse deleteRoutesMasterDetails(Integer routesId);

    public List<RoutesMasterDD> ddBusRoutesMasterDetails();



}
