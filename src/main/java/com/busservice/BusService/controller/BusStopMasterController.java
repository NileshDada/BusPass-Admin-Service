package com.busservice.BusService.controller;


import com.busservice.BusService.response.dropdown.BusStopMasterDD;
import com.busservice.BusService.response.dropdown.RoutesMasterDD;
import com.busservice.BusService.request.BusStopMasterCreateRequest;
import com.busservice.BusService.request.BusStopMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.BusStopMasterReponse;
import com.busservice.BusService.service.BusStopMasterService;
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
@RequestMapping(value = "/bus-stop-master")
public class BusStopMasterController {

    @Autowired
    private BusStopMasterService busStopMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> saveBusStopMaster(@RequestBody BusStopMasterCreateRequest busStopMasterCreateRequest) {
        System.out.println(busStopMasterCreateRequest);
        BusPassResponse response = busStopMasterService.saveBusStopMaster(busStopMasterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BusPassResponse> updateBusStopMaster(@RequestBody BusStopMasterUpdateRequest masterUpdateRequest) {
        System.out.println("masterUpdateRequest :"+masterUpdateRequest);
        BusPassResponse response = busStopMasterService.updateBusStopMaster(masterUpdateRequest);
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

    @GetMapping(value = "/by-busstopid")
    public ResponseEntity<BusStopMasterReponse> findBusStopMasterDetailsById(@RequestParam(required = false) Integer busStopId) {

        BusStopMasterReponse response = busStopMasterService.findBusStopMasterDetailsById(busStopId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deleteBusStopMasterDetails(@RequestParam(required = false) Integer busStopId) {
        BusPassResponse response = busStopMasterService.deleteBusStopMasterDetails(busStopId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/dd-routes")
    public ResponseEntity<List<RoutesMasterDD>> ddBusRoutesMasterDetails() {

        List<RoutesMasterDD> response = busStopMasterService.ddBusRoutesMasterDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/dd-bus-stop")
    public ResponseEntity<List<BusStopMasterDD>> ddBusStopMasterDetails(@RequestParam(required = false) Integer routesId) {

        List<BusStopMasterDD> response = busStopMasterService.ddBusStopMasterDetails(routesId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}