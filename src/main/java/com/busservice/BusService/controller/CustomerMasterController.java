package com.busservice.BusService.controller;


import com.busservice.BusService.request.BusStopMasterCreateRequest;
import com.busservice.BusService.request.CustomerMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.service.BusStopMasterService;
import com.busservice.BusService.service.CustomerMasterService;
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
@RequestMapping(value = "/customer-master")
public class CustomerMasterController {

    @Autowired
    private CustomerMasterService customerMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> saveCustomerMaster(@RequestBody CustomerMasterCreateRequest masterCreateRequest) {
        BusPassResponse response = customerMasterService.saveCustomerMaster(masterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findCustomerMasterDetails(@RequestParam(required = false) Integer custId,
                                                                     @RequestParam(required = false) String custName,
                                                                     @RequestParam(required = false) String statusCd,
                                                                     @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = customerMasterService.findCustomerMasterDetails(custId, custName, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deleteCustomerMasterDetails(@RequestParam(required = false) Integer custId) {
        BusPassResponse response = customerMasterService.deleteCustomerMasterDetails(custId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}