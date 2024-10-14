package com.busservice.BusService.controller;


import com.busservice.BusService.entity.PassTypeDocumentMasterEntity;
import com.busservice.BusService.request.PassTypeDocumentMasterCreateRequest;
import com.busservice.BusService.request.PassTypeMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.service.PassTypeDocumentMasterService;
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
@RequestMapping(value = "/pass-type-document-master")
public class PassTypeDocumentMasterController {

    @Autowired
    private PassTypeDocumentMasterService passTypeDocumentMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> savePassTypeDocumentMaster(@RequestBody PassTypeDocumentMasterCreateRequest documentMasterCreateRequest) {
        BusPassResponse response = passTypeDocumentMasterService.savePassTypeDocumentMaster(documentMasterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findPassTypeDocumentDetails(@RequestParam(required = false) Integer passTypeDocId,
                                                                     @RequestParam(required = false) Integer passTypeId,
                                                                     @RequestParam(required = false) String statusCd,
                                                                     @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = passTypeDocumentMasterService.findPassTypeDocumentDetails(passTypeDocId, passTypeId, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deletePassTypeDocumentMasterDetails(@RequestParam(required = false) Integer passTypeId) {
        BusPassResponse response = passTypeDocumentMasterService.deletePassTypeDocumentMasterDetails(passTypeId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}