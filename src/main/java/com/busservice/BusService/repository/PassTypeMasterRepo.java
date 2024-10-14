package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.BusStopMasterEntity;
import com.busservice.BusService.entity.PassTypeMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassTypeMasterRepo extends JpaRepository<PassTypeMasterEntity, Integer> {

    public Optional<BusStopMasterEntity> findByPassTypeNameEqualsIgnoreCase(String passTypeName);

    @Query(value = SQLQueryConstants.PASS_TYPE_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getPassTypeMasterDetail(@Param("passTypeId") Integer passTypeId, @Param("passTypeName") String passTypeName, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.PASS_TYPE_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getPassTypeMasterDetailsCount(@Param("passTypeId") Integer passTypeId, @Param("passTypeName") String passTypeName, @Param("statusCd") String statusCd);

    @Modifying
    @Query(value = "update pass_type_master set status_cd='I' where pass_type_id =:passTypeId", nativeQuery = true)
    public int deletePassTypeMasterDetails(@Param("passTypeId") Integer passTypeId);
}
