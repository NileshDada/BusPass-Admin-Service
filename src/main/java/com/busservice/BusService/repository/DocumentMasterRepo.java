package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.DocumentMasterEntity;
import com.busservice.BusService.entity.LanguageMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentMasterRepo extends JpaRepository<DocumentMasterEntity, Integer> {

    public Optional<DocumentMasterEntity> findByDocNameEqualsIgnoreCase(String langName);

    @Query(value = SQLQueryConstants.DOCUMENT_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getDocumentMasterDetail(@Param("docId") Integer docId, @Param("docName") String docName, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.DOCUMENT_MASTER_DETAILS_BY_DOC_ID, nativeQuery = true)
    List<Object[]> getDocumentMasterDetailByDocId(@Param("docId") Integer docId);


    @Query(value = SQLQueryConstants.DOCUMENT_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getDocumentMasterDetailsCount(@Param("docId") Integer docId, @Param("docName") String docName, @Param("statusCd") String statusCd);

    @Modifying
    @Query(value = "update document_master set status_cd='I', lst_updt_user_id=:employeeId where doc_id =:docId", nativeQuery = true)
    public int deleteDocumentMasterDetails(@Param("docId") Integer docId, @Param("employeeId") String employeeId);

    @Query(value = "select doc_id,doc_name from document_master where status_cd ='A'", nativeQuery = true)
    public List<Object[]> findDDDocumentMasterDetails();

    @Modifying
    @Query(value = "update document_master set doc_name=:docName,remark=:remark,lst_updt_user_id=:employeeId  where doc_id =:docId", nativeQuery = true)
    public int updateDocumentMasterDetails(@Param("docId") Integer docId,@Param("docName") String docName,@Param("remark") String remark,@Param("employeeId") String employeeId);

}
