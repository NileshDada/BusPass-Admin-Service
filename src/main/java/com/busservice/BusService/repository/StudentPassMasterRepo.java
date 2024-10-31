package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.BusStopMasterEntity;
import com.busservice.BusService.entity.StudentPassMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentPassMasterRepo extends JpaRepository<StudentPassMasterEntity, Integer> {

    public Optional<StudentPassMasterEntity> findByCustId(Integer custId);

    //For schedular
    @Query(value = SQLQueryConstants.PASS_SCHEDULAR_STUDENT_PASS_MASTER_DETAILS_BY_ID, nativeQuery = true)
    List<Object[]> passTypeSchedular(@Param("studPassExpiryDate") String studPassExpiryDate);

    @Query(value = SQLQueryConstants.STUDENT_PASS_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getStudentPassMasterDetail(@Param("studPassId") Integer studPassId, @Param("studPassStatus") String studPassStatus, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.STUDENT_PASS_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getStudentPassMasterDetailsCount(@Param("studPassId") Integer studPassId, @Param("studPassStatus") String studPassStatus, @Param("statusCd") String statusCd);

    @Modifying
    @Query(value = "update student_pass_master set status_cd='I' where stud_pass_id =:studPassId", nativeQuery = true)
    public int deleteStudentPassMasterDetails(@Param("studPassId") Integer studPassId);

    @Query(value = SQLQueryConstants.STUDENT_PASS_MASTER_DETAILS_BY_ID, nativeQuery = true)
    List<Object[]> getStudentPassMasterDetailById(@Param("studPassId") Integer studPassId);

}
