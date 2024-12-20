package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.entity.BusStopMasterEntity;
import com.busservice.BusService.entity.CustomerMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.BusStopMasterRepo;
import com.busservice.BusService.repository.CustomerMasterRepo;
import com.busservice.BusService.request.BusStopMasterCreateRequest;
import com.busservice.BusService.request.CustomerMasterCreateRequest;
import com.busservice.BusService.request.CustomerMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.BusStopMasterReponse;
import com.busservice.BusService.response.CustomerMasterReponse;
import com.busservice.BusService.response.LoginResponse;
import com.busservice.BusService.service.CustomerMasterService;
import com.busservice.BusService.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerMasterServiceImpl implements CustomerMasterService {

    @Autowired
    private CustomerMasterRepo customerMasterRepo;

    @Value("${customer-max-number}")
    private Integer customerMaxNumber;

    @Override
    public BusPassResponse saveCustomerMaster(CustomerMasterCreateRequest masterCreateRequest) {
        /*Optional<BusStopMasterEntity> optionalDepartmentEntity = busStopMasterRepo.findByBusStopNameEqualsIgnoreCase(masterCreateRequest.getBusStopName());
        if (optionalDepartmentEntity.isPresent()) {
            log.error("Inside BusStopMasterServiceImpl >> saveBusStopMaster()");
            throw new BusPassException("BusStopMasterServiceImpl Class", false, "Routes name already exist");
        }*/

        CustomerMasterEntity customerMasterEntity = convertCustomerMasterCreateRequestToEntity(masterCreateRequest);
        try {
            customerMasterRepo.save(customerMasterEntity);
            return BusPassResponse.builder()
                    .isSuccess(true)
                    .responseMessage(BusPassConstant.RECORD_SUCCESS)
                    .build();
        } catch (Exception ex) {
            log.error("Inside CustomerMasterServiceImpl >> saveBusStopMaster() : {}",ex);
            throw new BusPassException("CustomerMasterServiceImpl", false, ex.getMessage());
        }
    }

    @Transactional
    @Override
    public BusPassResponse updateCustomerMaster(CustomerMasterUpdateRequest masterUpdateRequest) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            customerMasterRepo.updateDocumentMasterDetails(masterUpdateRequest.getCustId(),masterUpdateRequest.getCustFirstName(),masterUpdateRequest.getCustMiddleName(),masterUpdateRequest.getCustLastName(),masterUpdateRequest.getCustAddress(),masterUpdateRequest.getCustMobileNo(),masterUpdateRequest.getCustEmailId(),masterUpdateRequest.getCustGender(),DateTimeUtils.convertStringToInstant(masterUpdateRequest.getCustDateOfBirth()), masterUpdateRequest.getRemark(), masterUpdateRequest.getEmployeeId());
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Customer details updated successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside DocumentMasterServiceImpl >> updateDocumentMaster : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }
    }

    @Override
    public BusPassResponse findCustomerMasterDetails(Integer custId, String custName, String statusCd, Pageable requestPageable) {
        try {
            String sortName = null;
            //  String sortDirection = null;
            Integer pageSize = requestPageable.getPageSize();
            Integer pageOffset = (int) requestPageable.getOffset();
            // pageable = KPIUtils.sort(requestPageable, sortParam, pageDirection);
            Optional<Sort.Order> order = requestPageable.getSort().get().findFirst();
            if (order.isPresent()) {
                sortName = order.get().getProperty();  //order by this field
                //sortDirection = order.get().getDirection().toString(); // Sort ASC or DESC
            }

            Integer totalCount = customerMasterRepo.getCustomerMasterDetailsCount(custId, custName, statusCd);
            List<Object[]> customerMasterData = customerMasterRepo.getCustomerMasterDetail(custId, custName, statusCd, sortName, pageSize, pageOffset);
            List<CustomerMasterReponse> customerMasterReponses = customerMasterData.stream().map(CustomerMasterReponse::new).collect(Collectors.toList());
            if (customerMasterReponses.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(customerMasterReponses, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("CustomerMasterServiceImpl >> findCustomerMasterDetails : {}", ex);
            throw new BusPassException("CustomerMasterServiceImpl", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .isSuccess(false)
                .build();
    }

    @Override
    public CustomerMasterReponse findCustomerMasterDetailsById(Integer custId) {
        try{
        List<Object[]> languageMasterData = customerMasterRepo.getCustomerMasterDetailById(custId);
        List<CustomerMasterReponse> customerMasterReponses = languageMasterData.stream().map(CustomerMasterReponse::new).collect(Collectors.toList());
        if (customerMasterReponses.size() > 0) {
            return customerMasterReponses.get(0);
        }
    } catch (Exception ex) {
        log.error("CustomerMasterServiceImpl >> findCustomerMasterDetailsById : {}", ex);
        throw new BusPassException("CustomerMasterServiceImpl >> findCustomerMasterDetailsById", false, ex.getMessage());
    }
        return null;
    }

    @Transactional
    @Override
    public BusPassResponse deleteCustomerMasterDetails(Integer custId) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            customerMasterRepo.deleteLanguageMasterDetails(custId);
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Customer details deleted Successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside CustomerMasterServiceImpl >> deleteCustomerMasterDetails : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }

    }

    @Override
    public BusPassResponse customerLoginDetails(String userName, String userPassword) {
        List<Object[]> employeeLogin = customerMasterRepo.customerLogin(userName, userPassword);
        List<LoginResponse> loginResponses = employeeLogin.stream().map(LoginResponse::new).collect(Collectors.toList());
        BusPassResponse response =null;
        if (!loginResponses.isEmpty()) {
                log.info("Login successfully");
                response = new BusPassResponse();
                response.setSuccess(true);
                response.setResponseMessage("Login successfully");
                response.setResponseData(loginResponses.get(0));


        } else {
            log.error("Inside EmployeeLoginServiceImpl >> employeeLogin()");
            response= new BusPassResponse();
            response.setSuccess(false);
                response.setResponseMessage("User name or Password is not correct. Please try again");
        }
        return response;
    }


    private CustomerMasterEntity convertCustomerMasterCreateRequestToEntity(CustomerMasterCreateRequest masterCreateRequest) {
        CustomerMasterEntity customerMasterEntity = new CustomerMasterEntity();
        String customerLoginUserName = "CUST" + getRandomNumber();
        customerMasterEntity.setCustFirstName(masterCreateRequest.getCustFirstName());
        customerMasterEntity.setCustMiddleName(masterCreateRequest.getCustMiddleName());
        customerMasterEntity.setCustLastName(masterCreateRequest.getCustLastName());
        customerMasterEntity.setCustGender(masterCreateRequest.getCustGender());
        customerMasterEntity.setCustAddress(masterCreateRequest.getCustAddress());
        customerMasterEntity.setCustMobileNo(masterCreateRequest.getCustMobileNo());
        customerMasterEntity.setCustEmailId(masterCreateRequest.getCustEmailId());
        customerMasterEntity.setCustDateOfBirth(DateTimeUtils.convertStringToInstant(masterCreateRequest.getCustDateOfBirth()));
        customerMasterEntity.setCustLoginUserName(customerLoginUserName);
        customerMasterEntity.setCustLoginUserPassword(customerLoginUserName);
        customerMasterEntity.setRoleId(1);
        customerMasterEntity.setCustStatus("Pending");
        customerMasterEntity.setRemark(masterCreateRequest.getRemark());
        customerMasterEntity.setStatusCd(masterCreateRequest.getStatusCd());
        customerMasterEntity.setCreatedUserId(masterCreateRequest.getEmployeeId());
        return customerMasterEntity;
    }

    private Integer getRandomNumber() {
        return (int) (Math.random() * customerMaxNumber);
    }
}
