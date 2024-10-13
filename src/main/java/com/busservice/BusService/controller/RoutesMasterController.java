package com.busservice.BusService.controller;


import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.request.RoutesMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.service.LanguageMasterService;
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
@RequestMapping(value = "/routes-master")
public class RoutesMasterController {

    @Autowired
    private RoutesMasterService routesMasterService;

    @PostMapping
    public ResponseEntity<BusPassResponse> saveLanguageMaster(@RequestBody RoutesMasterCreateRequest routesMasterCreateRequest) {
        BusPassResponse response = routesMasterService.saveRoutesMaster(routesMasterCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findLanguageMasterDetails(@RequestParam(required = false) Integer routesId,
                                                                     @RequestParam(required = false) String routesName,
                                                                     @RequestParam(required = false) String statusCd,
                                                                     @Parameter(hidden = true) Pageable pageable) {

        BusPassResponse response = routesMasterService.findRoutesMasterDetails(routesId, routesName, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<BusPassResponse> deleteLanguageMasterDetails(@RequestParam(required = false) Integer routesId) {
        BusPassResponse response = routesMasterService.deleteRoutesMasterDetails(routesId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}