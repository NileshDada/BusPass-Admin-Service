package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.CustomerMasterEntity;
import com.busservice.BusService.entity.LanguageMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerMasterRepo extends JpaRepository<CustomerMasterEntity, Integer> {

    @Query(value = "select cm.cust_id, cm.role_id, rm.role_name, cm.cust_first_name , cm.cust_middle_name, cm.cust_last_name, cm.cust_email_id from customer_master cm, role_master rm where cm.role_id = rm.role_id and cm.cust_login_user_name = :userName and cm.cust_login_password= :userPassword and cm.status_cd='A'", nativeQuery = true)
    public List<Object[]> customerLogin(@Param("userName") String userName, @Param("userPassword")String userPassword);


    @Query(value = SQLQueryConstants.CUSTOMER_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getCustomerMasterDetail(@Param("custId") Integer custId, @Param("custFirstName") String custFirstName, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.CUSTOMER_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getCustomerMasterDetailsCount(@Param("custId") Integer custId, @Param("custFirstName") String custFirstName, @Param("statusCd") String statusCd);

    @Modifying
    @Query(value = "update customer_master set status_cd='I' where cust_id =:custId", nativeQuery = true)
    public int deleteLanguageMasterDetails(@Param("custId") Integer custId);

    @Query(value = SQLQueryConstants.CUSTOMER_MASTER_DETAILS_BY_ID, nativeQuery = true)
    List<Object[]> getCustomerMasterDetailById(@Param("custId") Integer custId);

    @Modifying
    @Query(value = "update customer_master set cust_first_name=:custFirstName,cust_middle_name=:custMiddleName,cust_last_name=:custLastName,cust_address=:custAddress,cust_mobile_no=:custMobileNo,cust_email_id=:custEmailId,cust_gender=:custGender,cust_dob=:custDateOfBirth,remark=:remark,lst_updt_user_id=:employeeId  where cust_id =:custId", nativeQuery = true)
    public int updateDocumentMasterDetails(@Param("custId") Integer custId, @Param("custFirstName") String custFirstName, @Param("custMiddleName") String custMiddleName, @Param("custLastName") String custLastName, @Param("custAddress") String custAddress, @Param("custMobileNo") String custMobileNo, @Param("custEmailId") String custEmailId, @Param("custGender") String custGender, @Param("custDateOfBirth") Instant custDateOfBirth, @Param("remark") String remark, @Param("employeeId") String employeeId);


}
