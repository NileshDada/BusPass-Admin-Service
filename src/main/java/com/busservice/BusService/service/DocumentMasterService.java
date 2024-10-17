package com.busservice.BusService.service;

import com.busservice.BusService.request.DocumentMasterCreateRequest;
import com.busservice.BusService.request.DocumentMasterUpdateRequest;
import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.DocumentMasterReponse;
import org.springframework.data.domain.Pageable;

public interface DocumentMasterService {

    public BusPassResponse saveDocumentMaster(DocumentMasterCreateRequest masterCreateRequest);

    public BusPassResponse updateDocumentMaster(DocumentMasterUpdateRequest masterCreateRequest);

    public BusPassResponse findDocumentMasterDetails(Integer docId, String docName, String statusCd, Pageable pageable);

    public DocumentMasterReponse findDocumentMasterById(Integer docId);

    public BusPassResponse deleteDocumentMasterDetails(Integer docId, String employeeId);

    public BusPassResponse findDDDocumentMasterDetails();

}
