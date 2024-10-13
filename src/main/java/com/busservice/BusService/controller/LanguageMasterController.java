package com.busservice.BusService.controller;


import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.LanguageMasterReponse;
import com.busservice.BusService.response.dropdown.LanguageMasterDD;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/language-master")
public class LanguageMasterController {

    @Autowired
    private LanguageMasterService languageMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> saveLanguageMaster(@RequestBody LanguageMasterCreateRequest languageMasterCreateRequest) {
        BusPassResponse response = languageMasterService.saveLanguageMaster(languageMasterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findLanguageMasterDetails(@RequestParam(required = false) Integer langId,
                                                                     @RequestParam(required = false) String langName,
                                                                     @RequestParam(required = false) String statusCd,
                                                                     @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = languageMasterService.findLanguageMasterDetails(langId, langName, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deleteLanguageMasterDetails(@RequestParam(required = false) Integer langId) {
        BusPassResponse response = languageMasterService.deleteLanguageMasterDetails(langId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping (value = "/dd-language-master")
    public ResponseEntity<BusPassResponse> findDDLanguageMasterDetails() {
        BusPassResponse response = languageMasterService.findDDLanguageMasterDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}