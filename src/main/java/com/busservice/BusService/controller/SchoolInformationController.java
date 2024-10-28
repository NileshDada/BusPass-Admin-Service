package com.busservice.BusService.controller;

import com.busservice.BusService.dto.DDRoutesMasterResponse;
import com.busservice.BusService.request.SchoolInformationMasterCreateRequest;
import com.busservice.BusService.request.SchoolInformationMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.SchoolInformationMasterReponse;
import com.busservice.BusService.response.dropdown.SchoolInfoMasterDD;
import com.busservice.BusService.service.SchoolInformationMasterService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/school-info-master")
public class SchoolInformationController {

    @Autowired
    private SchoolInformationMasterService schoolInformationMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> saveSchoolInformationMaster(@RequestBody SchoolInformationMasterCreateRequest masterCreateRequest) {
        BusPassResponse response = schoolInformationMasterService.saveSchoolInformationMaster(masterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<BusPassResponse> updateSchoolInformationMaster(@RequestBody SchoolInformationMasterUpdateRequest masterUpdateRequest) {
        BusPassResponse response = schoolInformationMasterService.updateSchoolInformationMaster(masterUpdateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findSchoolInformationMasterDetailsPaging(@RequestParam(required = false) Integer schoolId,
                                                                                    @RequestParam(required = false) String schoolName,
                                                                                    @RequestParam(required = false) String schoolIdentificationNumber,
                                                                                    @RequestParam(required = false) String statusCd,
                                                                                    @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = schoolInformationMasterService.findSchoolInformationMasterDetailsPaging(schoolId, schoolName, schoolIdentificationNumber, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(value = "/by-schoolid")
    public ResponseEntity<SchoolInformationMasterReponse> findSchoolInformationMasterDetailsPaging(@RequestParam(required = false) Integer schoolId) {

        SchoolInformationMasterReponse response = schoolInformationMasterService.findSchoolInformationMasterBySchoolId(schoolId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deleteSchoolInformationMasterById(@RequestParam(required = false) Integer schoolId) {
        BusPassResponse response = schoolInformationMasterService.deleteSchoolInformationMasterById(schoolId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(value = "/dd-school-info")
    public ResponseEntity<List<SchoolInfoMasterDD>> ddSchoolInformationMasterDetails() {

        List<SchoolInfoMasterDD> response = schoolInformationMasterService.ddSchoolInformationMasterDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
