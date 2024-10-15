package com.busservice.BusService.service;

import com.busservice.BusService.response.BusPassResponse;
import org.springframework.data.domain.Pageable;

public interface RoleMasterService {
    public BusPassResponse findRoleDetails(Integer roleId, String roleName, String statusCd, Pageable pageable);
}
