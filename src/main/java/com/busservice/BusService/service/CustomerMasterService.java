package com.busservice.BusService.service;

import com.busservice.BusService.request.CustomerMasterCreateRequest;
import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import org.springframework.data.domain.Pageable;

public interface CustomerMasterService {

    public BusPassResponse saveCustomerMaster(CustomerMasterCreateRequest masterCreateRequest);

    public BusPassResponse findCustomerMasterDetails(Integer custId, String custFirstName, String statusCd, Pageable pageable);

    public BusPassResponse deleteCustomerMasterDetails(Integer custId);
}
