package com.busservice.BusService.service;

import com.busservice.BusService.request.BusStopMasterCreateRequest;
import com.busservice.BusService.request.RoutesMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import org.springframework.data.domain.Pageable;

public interface BusStopMasterService {

    public BusPassResponse saveBusStopMaster(BusStopMasterCreateRequest busStopMasterCreateRequest);

    public BusPassResponse findBusStopMasterDetails(Integer busStopId, String busStopName, String statusCd, Pageable pageable);

    public BusPassResponse deleteBusStopMasterDetails(Integer busStopId);



}
