package com.busservice.BusService.service;

import com.busservice.BusService.request.DocumentMasterCreateRequest;
import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import org.springframework.data.domain.Pageable;

public interface DocumentMasterService {

    public BusPassResponse saveDocumentMaster(DocumentMasterCreateRequest masterCreateRequest);

    public BusPassResponse findDocumentMasterDetails(Integer docId, String docName, String statusCd, Pageable pageable);

    public BusPassResponse deleteDocumentMasterDetails(Integer docId);

    public BusPassResponse findDDDocumentMasterDetails();

}
