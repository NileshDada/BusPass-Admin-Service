package com.busservice.BusService.service;

import com.busservice.BusService.request.StudentPassMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.StudentPassMasterReponse;
import com.busservice.BusService.response.dropdown.PassTypeMasterDD;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentPassMasterService {

    public BusPassResponse saveStudentPassMaster(StudentPassMasterCreateRequest masterCreateRequest);

    public BusPassResponse findStudentPassMasterDetails(Integer studPassId, String studPassStatus, String statusCd, Pageable pageable);

    public StudentPassMasterReponse findStudentPassMasterDetailsByStudPassId(Integer studPassId);



    public BusPassResponse deleteStudentPassMasterDetails(Integer studPassId);



}
