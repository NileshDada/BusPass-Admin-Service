package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.ReportStudentPassMasterEntity;
import com.busservice.BusService.entity.StudentPassMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportStudentPassMasterRepo extends JpaRepository<ReportStudentPassMasterEntity, Integer> {

    public Optional<ReportStudentPassMasterEntity> findByCustId(Integer custId);

    @Query(value = SQLQueryConstants.REPORT_STUDENT_PASS_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getStudentPassMasterDetail(@Param("reportStudPassId") Integer reportStudPassId,@Param("custId") Integer custId,@Param("studPassId") Integer studPassId, @Param("studPassStatus") String studPassStatus, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.REPORT_STUDENT_PASS_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getStudentPassMasterDetailsCount(@Param("reportStudPassId") Integer reportStudPassId,@Param("custId") Integer custId,@Param("studPassId") Integer studPassId, @Param("studPassStatus") String studPassStatus, @Param("statusCd") String statusCd);

    @Query(value = SQLQueryConstants.REPORT_STUDENT_PASS_MASTER_DETAILS_BY_ID, nativeQuery = true)
    List<Object[]> getStudentPassMasterDetailById(@Param("reportStudPassId") Integer reportStudPassId);

}
