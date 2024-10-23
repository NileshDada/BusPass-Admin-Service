package com.busservice.BusService.service;

import com.busservice.BusService.request.BusStopMasterCreateRequest;
import com.busservice.BusService.request.BusStopMasterUpdateRequest;
import com.busservice.BusService.request.RoutesMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.BusStopMasterReponse;
import org.springframework.data.domain.Pageable;

public interface BusStopMasterService {

    public BusPassResponse saveBusStopMaster(BusStopMasterCreateRequest busStopMasterCreateRequest);

    public BusPassResponse updateBusStopMaster(BusStopMasterUpdateRequest masterUpdateRequest);

    public BusPassResponse findBusStopMasterDetails(Integer busStopId, String busStopName, String statusCd, Pageable pageable);

    public BusStopMasterReponse findBusStopMasterDetailsById(Integer busStopId);

    public BusPassResponse deleteBusStopMasterDetails(Integer busStopId);




}
