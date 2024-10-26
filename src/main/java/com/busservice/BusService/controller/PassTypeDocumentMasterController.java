package com.busservice.BusService.controller;


import com.busservice.BusService.dto.PassTypeDocumentMasterDTO;
import com.busservice.BusService.entity.PassTypeDocumentMasterEntity;
import com.busservice.BusService.request.PassTypeDocumentMasterCreateRequest;
import com.busservice.BusService.request.PassTypeDocumentMasterUpdateRequest;
import com.busservice.BusService.request.PassTypeMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.PassTypeMasterReponse;
import com.busservice.BusService.response.SinglePassTypeDocumentMasterReponse;
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
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping
    public ResponseEntity<BusPassResponse> updatePassTypeDocumentMaster(@RequestBody PassTypeDocumentMasterUpdateRequest documentMasterUpdateRequest) {
        BusPassResponse response = passTypeDocumentMasterService.updatePassTypeDocumentMaster(documentMasterUpdateRequest);
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

    @GetMapping(value = "/by-passtypeid")
    public ResponseEntity<BusPassResponse> findPassTypeDocumentDetailsByPassId(@RequestParam(required = false) Integer passTypeDocId,
                                                                               @RequestParam(required = false) Integer passTypeId,
                                                                               @RequestParam(required = false) String statusCd) {

        BusPassResponse response = passTypeDocumentMasterService.findPassTypeDocumentDetailsByPassTypeId(passTypeDocId, passTypeId, statusCd);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/by-passtypedocid")
    public ResponseEntity<SinglePassTypeDocumentMasterReponse> findPassTypeDocumentDetailsById(@RequestParam(required = false) Integer passTypeDocId) {

        SinglePassTypeDocumentMasterReponse response = passTypeDocumentMasterService.findPassTypeDocumentDetailsById(passTypeDocId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deletePassTypeDocumentMasterDetails(@RequestParam(required = false) Integer passTypeDocId) {
        BusPassResponse response = passTypeDocumentMasterService.deletePassTypeDocumentMasterDetails(passTypeDocId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}