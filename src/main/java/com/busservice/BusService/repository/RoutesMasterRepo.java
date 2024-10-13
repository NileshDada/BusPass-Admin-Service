package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.LanguageMasterEntity;
import com.busservice.BusService.entity.RoutesMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoutesMasterRepo extends JpaRepository<RoutesMasterEntity, Integer> {

    public Optional<RoutesMasterEntity> findByRoutesNameEqualsIgnoreCase(String routesName);

    @Query(value = SQLQueryConstants.ROUTES_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getRoutesMasterDetail(@Param("routesId") Integer routesId, @Param("routesName") String routesName, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.ROUTES_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getRoutesMasterDetailsCount(@Param("routesId") Integer routesId, @Param("routesName") String routesName, @Param("statusCd") String statusCd);

    @Modifying
    @Query(value = "update routes_master set status_cd='I' where routes_id =:routesId", nativeQuery = true)
    public int deleteRoutesMasterDetails(@Param("routesId") Integer routesId);


}
