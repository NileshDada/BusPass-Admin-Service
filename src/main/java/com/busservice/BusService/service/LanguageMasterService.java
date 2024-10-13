package com.busservice.BusService.service;

import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import org.springframework.data.domain.Pageable;

public interface LanguageMasterService {

    public BusPassResponse saveLanguageMaster(LanguageMasterCreateRequest languageMasterCreateRequest);

    public BusPassResponse findLanguageMasterDetails(Integer langId, String langName, String statusCd, Pageable pageable);



}
