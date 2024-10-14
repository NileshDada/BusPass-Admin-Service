package com.busservice.BusService.service;

import com.busservice.BusService.request.PassTypeDocumentMasterCreateRequest;
import com.busservice.BusService.request.PassTypeMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import org.springframework.data.domain.Pageable;

public interface PassTypeDocumentMasterService {

    public BusPassResponse savePassTypeDocumentMaster(PassTypeDocumentMasterCreateRequest documentMasterCreateRequest);

    public BusPassResponse findPassTypeDocumentDetails(Integer passTypeDocId, Integer passTypeId, String statusCd, Pageable pageable);

    public BusPassResponse deletePassTypeDocumentMasterDetails(Integer passTypeDocId);



}
