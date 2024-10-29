package com.busservice.BusService.controller;


import com.busservice.BusService.response.dropdown.RoutesMasterDD;
import com.busservice.BusService.request.RoutesMasterCreateRequest;
import com.busservice.BusService.request.RoutesMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.RoutesMasterReponse;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/routes-master")
public class RoutesMasterController {

    @Autowired
    private RoutesMasterService routesMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> saveRoutesMaster(@RequestBody RoutesMasterCreateRequest routesMasterCreateRequest) {
        BusPassResponse response = routesMasterService.saveRoutesMaster(routesMasterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<BusPassResponse> updateRoutesMaster(@RequestBody RoutesMasterUpdateRequest routesMasterUpdateRequest) {

        BusPassResponse response = routesMasterService.updateRoutesMaster(routesMasterUpdateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findRoutesMasterDetails(@RequestParam(required = false) Integer routesId,
                                                                     @RequestParam(required = false) String routesName,
                                                                     @RequestParam(required = false) String statusCd,
                                                                     @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = routesMasterService.findRoutesMasterDetails(routesId, routesName, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/by-routesid")
    public ResponseEntity<RoutesMasterReponse> findRoutesMasterDetailsById(@RequestParam(required = false) Integer routesId) {

        RoutesMasterReponse response = routesMasterService.findRoutesMasterDetailsById(routesId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deleteRoutesMasterDetails(@RequestParam(required = false) Integer routesId) {
        BusPassResponse response = routesMasterService.deleteRoutesMasterDetails(routesId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/dd-routes")
    public ResponseEntity<List<RoutesMasterDD>> ddBusRoutesMasterDetails() {

        List<RoutesMasterDD> response = routesMasterService.ddBusRoutesMasterDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}