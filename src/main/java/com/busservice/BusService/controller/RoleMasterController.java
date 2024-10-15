package com.busservice.BusService.controller;

import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.service.RoleMasterService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/roles")
public class RoleMasterController {

    @Autowired
    private RoleMasterService roleService;


    @GetMapping(value = "/search")
    @PageableAsQueryParam
    public ResponseEntity<BusPassResponse> findRoleDetails(@RequestParam(required = false) Integer routesId,
                                                           @RequestParam(required = false) String routesName,
                                                           @RequestParam(required = false) String statusCd,
                                                           @Parameter(hidden = true) Pageable pageable) {
        BusPassResponse response = roleService.findRoleDetails(routesId, routesName, statusCd, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
