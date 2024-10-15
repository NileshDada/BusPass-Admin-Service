package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.dto.PassTypeDocumentMasterDTO;
import com.busservice.BusService.entity.BusStopMasterEntity;
import com.busservice.BusService.entity.PassTypeDocumentMasterEntity;
import com.busservice.BusService.entity.PassTypeMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.PassTypeDocumentMasterRepo;
import com.busservice.BusService.repository.PassTypeMasterRepo;
import com.busservice.BusService.request.PassTypeDocumentMasterCreateRequest;
import com.busservice.BusService.request.PassTypeMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.DocumentMasterReponse;
import com.busservice.BusService.response.PassTypeDocumentMasterReponse;
import com.busservice.BusService.response.PassTypeMasterReponse;
import com.busservice.BusService.service.PassTypeDocumentMasterService;
import com.busservice.BusService.service.PassTypeMasterService;
import com.busservice.BusService.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PassTypeDocumentMasterServiceImpl implements PassTypeDocumentMasterService {

    @Autowired
    private PassTypeDocumentMasterRepo passTypeDocumentMasterRepo;


    @Override
    public BusPassResponse savePassTypeDocumentMaster(PassTypeDocumentMasterCreateRequest documentMasterCreateRequest) {
        Optional<PassTypeDocumentMasterEntity> optionalPassTypeDocumentMasterEntity = passTypeDocumentMasterRepo.findByPassTypeIdAndDocId(documentMasterCreateRequest.getPassTypeId(),documentMasterCreateRequest.getDocId());
        if (optionalPassTypeDocumentMasterEntity.isPresent()) {
            log.error("Inside PassTypeDocumentMasterServiceImpl >> savePassTypeDocumentMaster()");
            throw new BusPassException("PassTypeDocumentMasterServiceImpl Class", false, "Routes name already exist");
        }

        PassTypeDocumentMasterEntity passTypeDocumentMasterEntity = convertPassTypeDocumentMasterCreateRequestToEntity(documentMasterCreateRequest);
        try {
            passTypeDocumentMasterRepo.save(passTypeDocumentMasterEntity);
            return BusPassResponse.builder()
                    .isSuccess(true)
                    .responseMessage(BusPassConstant.RECORD_SUCCESS)
                    .build();
        } catch (Exception ex) {
            log.error("Inside PassTypeDocumentMasterServiceImpl >> savePassTypeDocumentMaster(): {}",ex);
            throw new BusPassException("PassTypeDocumentMasterServiceImpl", false, ex.getMessage());
        }
    }

    @Override
    public BusPassResponse findPassTypeDocumentDetails(Integer passTypeDocId, Integer passTypeId, String statusCd, Pageable requestPageable) {
        try {
            log.debug("passTypeDocId : {}", passTypeDocId);
            List<PassTypeDocumentMasterReponse> passTypeDocumentMasterReponseList = new ArrayList<>();
            PassTypeDocumentMasterReponse documentMasterReponse = null;
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

            Integer totalCount = passTypeDocumentMasterRepo.getPassTypeDocumentMasterDetailsCount(passTypeDocId, passTypeId, statusCd);
            List<Object[]> passTypeMasterData = passTypeDocumentMasterRepo.getPassTypeDocumentMasterDetail(passTypeDocId, passTypeId, statusCd, sortName, pageSize, pageOffset);
            List<PassTypeDocumentMasterDTO> passTypeDocumentMasterDTOS = passTypeMasterData.stream().map(PassTypeDocumentMasterDTO::new).collect(Collectors.toList());

            Map<PassTypeMasterReponse, List<DocumentMasterReponse>> passTypeMasterReponseListMap =
                    passTypeDocumentMasterDTOS.stream().collect(Collectors.groupingBy(PassTypeDocumentMasterDTO::getPassTypeMasterReponse, Collectors.mapping(PassTypeDocumentMasterDTO::getDocumentMasterReponse, Collectors.toList())));

            for (Map.Entry<PassTypeMasterReponse, List<DocumentMasterReponse>> masterDtoListEntry : passTypeMasterReponseListMap.entrySet()) {
                documentMasterReponse = new PassTypeDocumentMasterReponse();
                documentMasterReponse.setPassTypeId(masterDtoListEntry.getKey().getPassTypeId());
                documentMasterReponse.setPassTypeName(masterDtoListEntry.getKey().getPassTypeName());
                documentMasterReponse.setPassTypeDescription(masterDtoListEntry.getKey().getPassTypeDescription());
                documentMasterReponse.setPassTypeEndDate(masterDtoListEntry.getKey().getPassTypeEndDate());
                documentMasterReponse.setPassTypeAmount(masterDtoListEntry.getKey().getPassTypeAmount());
                documentMasterReponse.setPassTypeCollectionLocation(masterDtoListEntry.getKey().getPassTypeCollectionLocation());
                documentMasterReponse.setDocumentMasterReponses(masterDtoListEntry.getValue());
                passTypeDocumentMasterReponseList.add(documentMasterReponse);

            }
            if (passTypeDocumentMasterReponseList.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(passTypeDocumentMasterReponseList, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("PassTypeDocumentMasterServiceImpl >> findPassTypeMasterDetails : {}", ex);
            throw new BusPassException("PassTypeDocumentMasterServiceImpl", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .isSuccess(false)
                .build();
    }

    @Transactional
    @Override
    public BusPassResponse deletePassTypeDocumentMasterDetails(Integer passTypeDocId) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            passTypeDocumentMasterRepo.deletePassTypeDocumentMasterDetails(passTypeDocId);
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Pass Type document details deleted Successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside PassTypeDocumentMasterServiceImpl >> deletePassTypeDocumentMasterDetails : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }

    }



    private PassTypeDocumentMasterEntity convertPassTypeDocumentMasterCreateRequestToEntity(PassTypeDocumentMasterCreateRequest documentMasterCreateRequest) {
        PassTypeDocumentMasterEntity documentMasterEntity = new PassTypeDocumentMasterEntity();

        documentMasterEntity.setPassTypeId(documentMasterCreateRequest.getPassTypeId());
        documentMasterEntity.setDocId(documentMasterCreateRequest.getDocId());
        documentMasterEntity.setRemark(documentMasterCreateRequest.getRemark());
        documentMasterEntity.setStatusCd(documentMasterCreateRequest.getStatusCd());
        documentMasterEntity.setCreatedUserId(documentMasterCreateRequest.getEmployeeId());
        return documentMasterEntity;
    }
}
