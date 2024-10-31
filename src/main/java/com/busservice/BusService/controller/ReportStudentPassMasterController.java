package com.busservice.BusService.controller;


import com.busservice.BusService.request.StudentPassMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.ReportStudentPassMasterReponse;
import com.busservice.BusService.response.StudentPassMasterReponse;
import com.busservice.BusService.service.ReportStudentPassMasterService;
import com.busservice.BusService.service.StudentPassMasterService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/report-student-pass-master")
@Slf4j
public class ReportStudentPassMasterController {

    @Autowired
    private ReportStudentPassMasterService studentPassMasterService;

    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findStudentPassMasterDetails(@RequestParam(required = false) Integer reportStudPassId,
                                                                        @RequestParam(required = false) Integer studPassId,
                                                                     @RequestParam(required = false) String studPassStatus,
                                                                     @RequestParam(required = false) String statusCd,
                                                                     @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = studentPassMasterService.findStudentPassMasterDetails(reportStudPassId, studPassId, studPassStatus, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/by-reportstudpassid")
    public ResponseEntity<ReportStudentPassMasterReponse> findStudentPassMasterDetailsByStudPassId(@RequestParam(required = false) Integer reportStudPassId) {

        ReportStudentPassMasterReponse response = studentPassMasterService.findStudentPassMasterDetailsByStudPassId(reportStudPassId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}