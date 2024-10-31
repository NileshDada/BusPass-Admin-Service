package com.busservice.BusService.service;

import com.busservice.BusService.request.StudentPassMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.ReportStudentPassMasterReponse;
import com.busservice.BusService.response.StudentPassMasterReponse;
import org.springframework.data.domain.Pageable;

public interface ReportStudentPassMasterService {

    public BusPassResponse findStudentPassMasterDetails(Integer reportStudPassId,Integer custId, Integer studPassId, String studPassStatus, String statusCd, Pageable pageable);

    public ReportStudentPassMasterReponse findStudentPassMasterDetailsByStudPassId(Integer reportStudPassId);

    public BusPassResponse passTypeSchedular();
}
