package com.busservice.BusService.controller;


import com.busservice.BusService.request.BusStopMasterCreateRequest;
import com.busservice.BusService.request.RoutesMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.service.BusStopMasterService;
import com.busservice.BusService.service.RoutesMasterService;
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
@RequestMapping(value = "/bus-stop-master")
public class BusStopMasterController {

    @Autowired
    private BusStopMasterService busStopMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> saveBusStopMaster(@RequestBody BusStopMasterCreateRequest busStopMasterCreateRequest) {
        BusPassResponse response = busStopMasterService.saveBusStopMaster(busStopMasterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findBusStopMasterDetails(@RequestParam(required = false) Integer busStopId,
                                                                     @RequestParam(required = false) String busStopName,
                                                                     @RequestParam(required = false) String statusCd,
                                                                     @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = busStopMasterService.findBusStopMasterDetails(busStopId, busStopName, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deleteBusStopMasterDetails(@RequestParam(required = false) Integer busStopId) {
        BusPassResponse response = busStopMasterService.deleteBusStopMasterDetails(busStopId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}