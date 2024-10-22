package com.busservice.BusService.repository;

import com.busservice.BusService.constant.SQLQueryConstants;
import com.busservice.BusService.entity.LanguageMasterEntity;
import com.busservice.BusService.entity.SchoolInformationMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolInformationMasterRepo extends JpaRepository<SchoolInformationMasterEntity, Integer> {

   public Optional<SchoolInformationMasterEntity> findBySchoolNameEqualsIgnoreCase(String schoolName);

     @Query(value = SQLQueryConstants.SCHOOL_INFORMATION_MASTER_DETAILS_BY_PAGING, nativeQuery = true)
    List<Object[]> getSchoolInformationrDetail(@Param("schoolId") Integer schoolId, @Param("schoolName") String schoolName,@Param("schoolIdentificationNumber") String schoolIdentificationNumber, @Param("statusCd") String statusCd, @Param("sortName") String sortName, @Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset);

    @Query(value = SQLQueryConstants.SCHOOL_INFORMATION_MASTER_DETAILS_BY_PAGING_COUNT, nativeQuery = true)
    Integer getSchoolInformationrDetailCount(@Param("schoolId") Integer schoolId, @Param("schoolName") String schoolName,@Param("schoolIdentificationNumber") String schoolIdentificationNumber, @Param("statusCd") String statusCd);

    @Query(value = SQLQueryConstants.SCHOOL_INFORMATION_MASTER_DETAILS_BY_ID, nativeQuery = true)
    List<Object[]> getSchoolInformationrDetailById(@Param("schoolId") Integer schoolId);

    @Modifying
    @Query(value = "update school_information_master set status_cd='I' where school_id =:schoolId", nativeQuery = true)
    public int deleteLanguageMasterDetails(@Param("schoolId") Integer schoolId);

   /* @Modifying
    @Query(value = "update language_master set lang_name=:langName,remark=:remark,lst_updt_user_id=:employeeId  where lang_id =:langId", nativeQuery = true)
    public int updateLanguageMasterDetails(@Param("langId") Integer langId,@Param("langName") String langName,@Param("remark") String remark,@Param("employeeId") String employeeId);

    @Query(value = "select lang_id,lang_name from language_master where status_cd ='A'", nativeQuery = true)
    public List<Object[]> findDDLanguageMasterDetails();

    @Query(value = SQLQueryConstants.LANGUAGE_MASTER_DETAILS_BY_LANG_ID, nativeQuery = true)
    List<Object[]> getLanguageMasterByLangId(@Param("langId") Integer langId);*/

}
