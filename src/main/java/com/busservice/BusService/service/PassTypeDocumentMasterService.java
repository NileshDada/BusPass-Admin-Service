package com.busservice.BusService.service;

import com.busservice.BusService.dto.PassTypeDocumentMasterDTO;
import com.busservice.BusService.request.PassTypeDocumentMasterCreateRequest;
import com.busservice.BusService.request.PassTypeDocumentMasterUpdateRequest;
import com.busservice.BusService.request.PassTypeMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.PassTypeMasterReponse;
import com.busservice.BusService.response.SinglePassTypeDocumentMasterReponse;
import org.springframework.data.domain.Pageable;

public interface PassTypeDocumentMasterService {

    public BusPassResponse savePassTypeDocumentMaster(PassTypeDocumentMasterCreateRequest documentMasterCreateRequest);

    public BusPassResponse updatePassTypeDocumentMaster(PassTypeDocumentMasterUpdateRequest documentMasterUpdateRequest);
    public BusPassResponse findPassTypeDocumentDetails(Integer passTypeDocId, Integer passTypeId, String statusCd, Pageable pageable);

    public BusPassResponse findPassTypeDocumentDetailsByPassTypeId(Integer passTypeDocId, Integer passTypeId, String statusCd);

    public SinglePassTypeDocumentMasterReponse findPassTypeDocumentDetailsById(Integer passTypeDocId);
    public BusPassResponse deletePassTypeDocumentMasterDetails(Integer passTypeDocId);



}
