package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.BusStopMasterEntity;
import com.busservice.BusService.entity.RoutesMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusStopMasterRepo extends JpaRepository<BusStopMasterEntity, Integer> {

    public Optional<BusStopMasterEntity> findByBusStopNameEqualsIgnoreCase(String busStopName);

    @Query(value = SQLQueryConstants.BUS_STOP_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getBusStopMasterDetail(@Param("busStopId") Integer busStopId, @Param("busStopName") String busStopName, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.BUS_STOP_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getBusStopMasterDetailsCount(@Param("busStopId") Integer busStopId, @Param("busStopName") String busStopName, @Param("statusCd") String statusCd);

    @Modifying
    @Query(value = "update bus_stop_master set status_cd='I' where bus_stop_id =:busStopId", nativeQuery = true)
    public int deleteBusStopMasterDetails(@Param("busStopId") Integer busStopId);

    @Query(value = SQLQueryConstants.BUS_STOP_MASTER_DETAILS_BY_ID, nativeQuery = true)
    List<Object[]> getBusStopMasterDetailById(@Param("busStopId") Integer busStopId);

    @Query(value = SQLQueryConstants.ROUTES_NAME_FROM_BUS_STOP_MASTER, nativeQuery = true)
    List<Object[]> ddRouteNameFromBusStopMaster();

}
