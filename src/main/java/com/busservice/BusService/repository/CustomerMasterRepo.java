package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.CustomerMasterEntity;
import com.busservice.BusService.entity.LanguageMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerMasterRepo extends JpaRepository<CustomerMasterEntity, Integer> {



    @Query(value = SQLQueryConstants.CUSTOMER_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getCustomerMasterDetail(@Param("custId") Integer custId, @Param("custFirstName") String custFirstName, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.CUSTOMER_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getCustomerMasterDetailsCount(@Param("custId") Integer custId, @Param("custFirstName") String custFirstName, @Param("statusCd") String statusCd);

    @Modifying
    @Query(value = "update customer_master set status_cd='I' where cust_id =:custId", nativeQuery = true)
    public int deleteLanguageMasterDetails(@Param("custId") Integer custId);

}
