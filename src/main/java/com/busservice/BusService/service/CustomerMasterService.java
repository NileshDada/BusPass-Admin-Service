package com.busservice.BusService.service;

import com.busservice.BusService.request.CustomerMasterCreateRequest;
import com.busservice.BusService.request.CustomerMasterUpdateRequest;
import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.CustomerMasterReponse;
import org.springframework.data.domain.Pageable;

public interface CustomerMasterService {

    public BusPassResponse saveCustomerMaster(CustomerMasterCreateRequest masterCreateRequest);

    public BusPassResponse updateCustomerMaster(CustomerMasterUpdateRequest masterCreateRequest);

    public BusPassResponse findCustomerMasterDetails(Integer custId, String custFirstName, String statusCd, Pageable pageable);

    public CustomerMasterReponse findCustomerMasterDetailsById(Integer custId);

    public BusPassResponse deleteCustomerMasterDetails(Integer custId);

    public BusPassResponse customerLoginDetails(String custId, String custName);
}
