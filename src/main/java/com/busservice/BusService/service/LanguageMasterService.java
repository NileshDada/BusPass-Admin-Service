package com.busservice.BusService.service;

import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.request.LanguageMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.LanguageMasterReponse;
import com.busservice.BusService.response.dropdown.LanguageMasterDD;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LanguageMasterService {

    public BusPassResponse saveLanguageMaster(LanguageMasterCreateRequest languageMasterCreateRequest);

    public BusPassResponse updateLanguageMaster(LanguageMasterUpdateRequest languageMasterUpdateRequest);

    public BusPassResponse findLanguageMasterDetails(Integer langId, String langName, String statusCd, Pageable pageable);

    public LanguageMasterReponse findLanguageMasterByLangId(Integer langId);

    public BusPassResponse deleteLanguageMasterDetails(Integer langId);

    public BusPassResponse findDDLanguageMasterDetails();

}
