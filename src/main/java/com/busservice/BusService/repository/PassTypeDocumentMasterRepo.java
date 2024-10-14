package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.PassTypeDocumentMasterEntity;
import com.busservice.BusService.entity.RoutesMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassTypeDocumentMasterRepo extends JpaRepository<PassTypeDocumentMasterEntity, Integer> {

    public Optional<PassTypeDocumentMasterEntity> findByPassTypeIdAndDocId(Integer passTypeId,Integer docId);

    @Query(value = SQLQueryConstants.PASS_TYPE_DOCUMENT_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getPassTypeDocumentMasterDetail(@Param("passTypeDocId") Integer passTypeDocId, @Param("passTypeId") Integer passTypeId, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.PASS_TYPE_DOCUMENT_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getPassTypeDocumentMasterDetailsCount(@Param("passTypeDocId") Integer passTypeDocId, @Param("passTypeId") Integer passTypeId, @Param("statusCd") String statusCd);

    @Modifying
    @Query(value = "update pass_type_document_master set status_cd='I' where pass_type_doc_id =:passTypeDocId", nativeQuery = true)
    public int deletePassTypeDocumentMasterDetails(@Param("passTypeDocId") Integer passTypeDocId);


}
