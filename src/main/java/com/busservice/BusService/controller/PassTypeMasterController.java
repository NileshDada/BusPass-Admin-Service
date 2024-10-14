package com.busservice.BusService.controller;


import com.busservice.BusService.request.BusStopMasterCreateRequest;
import com.busservice.BusService.request.PassTypeMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.service.BusStopMasterService;
import com.busservice.BusService.service.PassTypeMasterService;
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
@RequestMapping(value = "/pass-type-master")
public class PassTypeMasterController {

    @Autowired
    private PassTypeMasterService passTypeMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> savePassTypeMaster(@RequestBody PassTypeMasterCreateRequest passTypeMasterCreateRequest) {
        BusPassResponse response = passTypeMasterService.savePassTypeMaster(passTypeMasterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findPassTypeMasterDetails(@RequestParam(required = false) Integer passTypeId,
                                                                     @RequestParam(required = false) String passTypeName,
                                                                     @RequestParam(required = false) String statusCd,
                                                                     @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = passTypeMasterService.findPassTypeMasterDetails(passTypeId, passTypeName, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deletePassTypeMasterDetails(@RequestParam(required = false) Integer passTypeId) {
        BusPassResponse response = passTypeMasterService.deletePassTypeMasterDetails(passTypeId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}