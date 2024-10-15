package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.RoleMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMasterRepo extends JpaRepository<RoleMasterEntity, Integer> {

    @Query(value = SQLQueryConstants.ROLE_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getRoleMasterDetail(@Param("roleId") Integer roleId, @Param("roleName") String roleName, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.ROLE_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getRoleMasterDetailsCount(@Param("roleId") Integer roleId, @Param("roleName") String roleName, @Param("statusCd") String statusCd);

}
