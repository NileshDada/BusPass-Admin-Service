package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.dto.SchedularStudentPassDTO;
import com.busservice.BusService.entity.ReportStudentPassMasterEntity;
import com.busservice.BusService.entity.StudentPassMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.ReportStudentPassMasterRepo;
import com.busservice.BusService.repository.StudentPassMasterRepo;
import com.busservice.BusService.request.StudentPassMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.ReportStudentPassMasterReponse;
import com.busservice.BusService.response.StudentPassMasterReponse;
import com.busservice.BusService.service.ReportStudentPassMasterService;
import com.busservice.BusService.service.StudentPassMasterService;
import com.busservice.BusService.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReportStudentPassMasterServiceImpl implements ReportStudentPassMasterService {

    @Autowired
    private ReportStudentPassMasterRepo reportStudentPassMasterRepo;

    @Autowired
    private StudentPassMasterRepo studentPassMasterRepo;


    @Override
    public BusPassResponse findStudentPassMasterDetails(Integer reportStudPassId,Integer custId, Integer studPassId, String studPassStatus, String statusCd, Pageable requestPageable) {
        try {
            String sortName = null;
            //  String sortDirection = null;
            Integer pageSize = requestPageable.getPageSize();
            Integer pageOffset = (int) requestPageable.getOffset();
            // pageable = KPIUtils.sort(requestPageable, sortParam, pageDirection);
            Optional<Sort.Order> order = requestPageable.getSort().get().findFirst();
            if (order.isPresent()) {
                sortName = order.get().getProperty();  //order by this field
                //sortDirection = order.get().getDirection().toString(); // Sort ASC or DESC
            }

            Integer totalCount = reportStudentPassMasterRepo.getStudentPassMasterDetailsCount(reportStudPassId,custId, studPassId, studPassStatus, statusCd);
            List<Object[]> studentPassMasterData = reportStudentPassMasterRepo.getStudentPassMasterDetail(reportStudPassId,custId, studPassId, studPassStatus, statusCd, sortName, pageSize, pageOffset);
            List<ReportStudentPassMasterReponse> studentPassMasterReponses = studentPassMasterData.stream().map(ReportStudentPassMasterReponse::new).collect(Collectors.toList());
            if (studentPassMasterReponses.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(studentPassMasterReponses, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("StudentPassMasterServiceImpl >> findStudentPassMasterDetails : {}", ex);
            throw new BusPassException("StudentPassMasterServiceImpl", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .responseMessage("History not available for pass type")
                .isSuccess(false)
                .build();
    }


    @Override
    public ReportStudentPassMasterReponse findStudentPassMasterDetailsByStudPassId(Integer studPassId) {
        try {
            List<Object[]> studentPassMasterData = reportStudentPassMasterRepo.getStudentPassMasterDetailById(studPassId);
            List<ReportStudentPassMasterReponse> studentPassMasterReponses = studentPassMasterData.stream().map(ReportStudentPassMasterReponse::new).collect(Collectors.toList());
            if (studentPassMasterReponses.size() > 0) {
                return studentPassMasterReponses.get(0);
            }
        } catch (Exception ex) {
            log.error("StudentPassMasterServiceImpl >> findStudentPassMasterDetails : {}", ex);
            throw new BusPassException("StudentPassMasterServiceImpl", false, ex.getMessage());
        }
        return null;
    }

    @Override
    public BusPassResponse passTypeSchedular() {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            List<ReportStudentPassMasterEntity> reportStudentPassMasterEntities = new ArrayList<>();
            ReportStudentPassMasterEntity reportStudentPassMasterEntity = new ReportStudentPassMasterEntity();
            List<Object[]> studentBusPassData = studentPassMasterRepo.passTypeSchedular(LocalDate.now().toString());

            List<SchedularStudentPassDTO> schedularStudentPassDTOList = studentBusPassData.stream().map(SchedularStudentPassDTO::new).collect(Collectors.toList());

            for (SchedularStudentPassDTO schedularDTO : schedularStudentPassDTOList) {
                reportStudentPassMasterEntity = new ReportStudentPassMasterEntity();
                reportStudentPassMasterEntity.setStudPassId(schedularDTO.getStudPassId());
                reportStudentPassMasterEntity.setPassTypeId(schedularDTO.getPassTypeId());
                reportStudentPassMasterEntity.setStudPassFormNo(schedularDTO.getStudPassFormNo());
                reportStudentPassMasterEntity.setCustId(schedularDTO.getCustId());
                reportStudentPassMasterEntity.setPassTypeId(schedularDTO.getPassTypeId());
                reportStudentPassMasterEntity.setStudPassCreatedDate(DateTimeUtils.convertStringToInstant(schedularDTO.getStudPassCreatedDate()));
                reportStudentPassMasterEntity.setStudPassExpiryDate(DateTimeUtils.convertStringToInstant(schedularDTO.getStudPassExpiryDate()));
                reportStudentPassMasterEntity.setRoutesId(schedularDTO.getRoutesId());
                reportStudentPassMasterEntity.setFromBusStopId(schedularDTO.getFromBusStopId());
                reportStudentPassMasterEntity.setToBusStopId(schedularDTO.getToBusStopId());
                reportStudentPassMasterEntity.setStudPassAmount(schedularDTO.getStudPassAmount());
                reportStudentPassMasterEntity.setStudPassStatus(schedularDTO.getStudPassStatus());
                reportStudentPassMasterEntity.setStudPassAmountPaidStatus(schedularDTO.getStudPassAmountPaidStatus());
                reportStudentPassMasterEntity.setSchoolId(schedularDTO.getSchoolId());
                reportStudentPassMasterEntity.setSchoolIdentificationNumber(schedularDTO.getSchoolIdentificationNumber());
                reportStudentPassMasterEntity.setStudCourseName(schedularDTO.getStudCourseName());
                reportStudentPassMasterEntity.setStudClassName(schedularDTO.getStudClassName());
                reportStudentPassMasterEntity.setStudRollNo(schedularDTO.getStudRollNo());
                reportStudentPassMasterEntity.setRemark(schedularDTO.getRemark());
                reportStudentPassMasterEntity.setStatusCd(schedularDTO.getStatusCd());
                reportStudentPassMasterEntity.setCreatedUserId("Schedular");
                reportStudentPassMasterEntities.add(reportStudentPassMasterEntity);
                studentPassMasterRepo.deleteById(schedularDTO.getStudPassId());
            }
            reportStudentPassMasterRepo.saveAll(reportStudentPassMasterEntities);
            busPassResponse.setResponseMessage("Schedular completed");
            busPassResponse.setSuccess(true);
        } catch (Exception ex) {
            log.error("StudentPassMasterServiceImpl >> findStudentPassMasterDetails : {}", ex);
            throw new BusPassException("StudentPassMasterServiceImpl", false, ex.getMessage());
        }
        return busPassResponse;
    }
}

