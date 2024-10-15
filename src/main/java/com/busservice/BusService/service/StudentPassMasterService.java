package com.busservice.BusService.service;

import com.busservice.BusService.request.StudentPassMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import org.springframework.data.domain.Pageable;

public interface StudentPassMasterService {

    public BusPassResponse saveStudentPassMaster(StudentPassMasterCreateRequest masterCreateRequest);

    public BusPassResponse findStudentPassMasterDetails(Integer studPassId, String studPassStatus, String statusCd, Pageable pageable);

    public BusPassResponse deleteStudentPassMasterDetails(Integer studPassId);



}
