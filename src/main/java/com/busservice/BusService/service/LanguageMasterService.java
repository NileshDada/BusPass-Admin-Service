package com.busservice.BusService.service;

import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;

public interface LanguageMasterService {

    public BusPassResponse saveLanguageMaster(LanguageMasterCreateRequest languageMasterCreateRequest);



}
