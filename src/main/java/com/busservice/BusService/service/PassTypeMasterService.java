package com.busservice.BusService.service;

import com.busservice.BusService.request.BusStopMasterCreateRequest;
import com.busservice.BusService.request.PassTypeMasterCreateRequest;
import com.busservice.BusService.request.PassTypeMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.PassTypeMasterReponse;
import org.springframework.data.domain.Pageable;

public interface PassTypeMasterService {

    public BusPassResponse savePassTypeMaster(PassTypeMasterCreateRequest passTypeMasterCreateRequest);

    public BusPassResponse updatePassTypeMaster(PassTypeMasterUpdateRequest masterUpdateRequest);

    public BusPassResponse findPassTypeMasterDetails(Integer passTypeId, String passTypeName, String statusCd, Pageable pageable);

    public PassTypeMasterReponse findPassTypeMasterDetailsById(Integer passTypeId);

    public BusPassResponse deletePassTypeMasterDetails(Integer passTypeId);



}
