package com.busservice.BusService.controller;


import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.service.LanguageMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}