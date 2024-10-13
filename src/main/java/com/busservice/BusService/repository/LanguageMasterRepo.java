package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.LanguageMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageMasterRepo extends JpaRepository<LanguageMasterEntity, Integer> {

    public Optional<LanguageMasterEntity> findByLangNameEqualsIgnoreCase(String langName);

    @Query(value = SQLQueryConstants.LANGUAGE_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getLanguageMasterDetail(@Param("langId") Integer langId,@Param("langName") String langName,@Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.LANGUAGE_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getLanguageMasterDetailsCount(@Param("langId") Integer langId,@Param("langName") String langName,@Param("statusCd") String statusCd);

}