package com.busservice.BusService.controller;


import com.busservice.BusService.request.BusStopMasterCreateRequest;
import com.busservice.BusService.request.StudentPassMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.service.BusStopMasterService;
import com.busservice.BusService.service.StudentPassMasterService;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping(value = "/student-pass-master")
public class StudentPassMasterController {

    @Autowired
    private StudentPassMasterService studentPassMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> saveStudentPassMaster(@RequestBody StudentPassMasterCreateRequest busStopMasterCreateRequest) {
        BusPassResponse response = studentPassMasterService.saveStudentPassMaster(busStopMasterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findStudentPassMasterDetails(@RequestParam(required = false) Integer studPassId,
                                                                     @RequestParam(required = false) String studPassStatus,
                                                                     @RequestParam(required = false) String statusCd,
                                                                     @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = studentPassMasterService.findStudentPassMasterDetails(studPassId, studPassStatus, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deleteStudentPassMasterDetails(@RequestParam(required = false) Integer studPassId) {
        BusPassResponse response = studentPassMasterService.deleteStudentPassMasterDetails(studPassId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}