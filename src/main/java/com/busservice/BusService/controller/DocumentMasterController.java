package com.busservice.BusService.controller;


import com.busservice.BusService.request.DocumentMasterCreateRequest;
import com.busservice.BusService.request.DocumentMasterUpdateRequest;
import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.DocumentMasterReponse;
import com.busservice.BusService.response.dropdown.DocumentMasterDD;
import com.busservice.BusService.service.DocumentMasterService;
import com.busservice.BusService.service.LanguageMasterService;
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
@RequestMapping(value = "/document-master")
public class DocumentMasterController {

    @Autowired
    private DocumentMasterService documentMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> saveDocumentMaster(@RequestBody DocumentMasterCreateRequest documentMasterCreateRequest) {
        BusPassResponse response = documentMasterService.saveDocumentMaster(documentMasterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<BusPassResponse> updateDocumentMaster(@RequestBody DocumentMasterUpdateRequest documentMasterCreateRequest) {
        BusPassResponse response = documentMasterService.updateDocumentMaster(documentMasterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findDocumentMasterDetails(@RequestParam(required = false) Integer docId,
                                                                     @RequestParam(required = false) String docName,
                                                                     @RequestParam(required = false) String statusCd,
                                                                     @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = documentMasterService.findDocumentMasterDetails(docId, docName, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/by-docid")
    public ResponseEntity<DocumentMasterReponse> findDocumentMasterById(@RequestParam(required = false) Integer docId) {

        DocumentMasterReponse response = documentMasterService.findDocumentMasterById(docId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deleteLanguageMasterDetails(@RequestParam(required = false) Integer docId, @RequestParam(required = false) String employeeId) {
        BusPassResponse response = documentMasterService.deleteDocumentMasterDetails(docId,employeeId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping (value = "/dd-document-master")
    public ResponseEntity< List<DocumentMasterDD>> ddDocumentMasterDetails() {
        List<DocumentMasterDD> response = documentMasterService.ddDocumentMasterDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}