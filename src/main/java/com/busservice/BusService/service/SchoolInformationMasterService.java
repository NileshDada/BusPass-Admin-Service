package com.busservice.BusService.service;

import com.busservice.BusService.dto.DDRoutesMasterResponse;
import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.request.LanguageMasterUpdateRequest;
import com.busservice.BusService.request.SchoolInformationMasterCreateRequest;
import com.busservice.BusService.request.SchoolInformationMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.LanguageMasterReponse;
import com.busservice.BusService.response.SchoolInformationMasterReponse;
import com.busservice.BusService.response.dropdown.SchoolInfoMasterDD;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolInformationMasterService {

    public BusPassResponse saveSchoolInformationMaster(SchoolInformationMasterCreateRequest masterCreateRequest);

    public BusPassResponse updateSchoolInformationMaster(SchoolInformationMasterUpdateRequest masterUpdateRequest);

    public BusPassResponse findSchoolInformationMasterDetailsPaging(Integer schoolId, String schoolName,String schoolIdentificationNumber, String statusCd, Pageable pageable);


    public SchoolInformationMasterReponse findSchoolInformationMasterBySchoolId(Integer schoolId);

    public BusPassResponse deleteSchoolInformationMasterById(Integer schoolId);

    public List<SchoolInfoMasterDD> ddSchoolInformationMasterDetails();
}
