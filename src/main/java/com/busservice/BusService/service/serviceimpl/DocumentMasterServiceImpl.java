package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.entity.DocumentMasterEntity;
import com.busservice.BusService.entity.LanguageMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.DocumentMasterRepo;
import com.busservice.BusService.repository.LanguageMasterRepo;
import com.busservice.BusService.request.DocumentMasterCreateRequest;
import com.busservice.BusService.request.DocumentMasterUpdateRequest;
import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.DocumentMasterReponse;
import com.busservice.BusService.response.LanguageMasterReponse;
import com.busservice.BusService.response.dropdown.DocumentMasterDD;
import com.busservice.BusService.response.dropdown.LanguageMasterDD;
import com.busservice.BusService.service.DocumentMasterService;
import com.busservice.BusService.service.LanguageMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DocumentMasterServiceImpl implements DocumentMasterService {

    @Autowired
    private DocumentMasterRepo documentMasterRepo;


    @Override
    public BusPassResponse saveDocumentMaster(DocumentMasterCreateRequest documentMasterCreateRequest) {
        Optional<DocumentMasterEntity> optionalDocumentMasterEntity = documentMasterRepo.findByDocNameEqualsIgnoreCase(documentMasterCreateRequest.getDocName());
        if (optionalDocumentMasterEntity.isPresent()) {
            log.error("Inside DocumentMasterServiceImpl >> saveDocumentMaster()");
            throw new BusPassException("DocumentMasterServiceImpl Class", false, "Document name already exist");
        }

        DocumentMasterEntity documentMasterEntity = convertDocumentMasterCreateRequestToEntity(documentMasterCreateRequest);
        try {
            documentMasterRepo.save(documentMasterEntity);

            return BusPassResponse.builder()
                    .isSuccess(true)
                    .responseMessage(BusPassConstant.RECORD_SUCCESS)
                    .build();
        } catch (Exception ex) {
            log.error("Inside DocumentMasterServiceImpl >> saveDocumentMaster()");
            throw new BusPassException("DocumentMasterServiceImpl", false, ex.getMessage());
        }
    }

    @Transactional
    @Override
    public BusPassResponse updateDocumentMaster(DocumentMasterUpdateRequest documentMasterUpdateRequest) {

        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            documentMasterRepo.updateDocumentMasterDetails(documentMasterUpdateRequest.getDocId(), documentMasterUpdateRequest.getDocName(), documentMasterUpdateRequest.getRemark(), documentMasterUpdateRequest.getEmployeeId());
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Document updated successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside DocumentMasterServiceImpl >> updateDocumentMaster : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }
    }

    @Override
    public BusPassResponse findDocumentMasterDetails(Integer docId, String docName, String statusCd, Pageable requestPageable) {
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

            Integer totalCount = documentMasterRepo.getDocumentMasterDetailsCount(docId, docName, statusCd);
            List<Object[]> documentMasterData = documentMasterRepo.getDocumentMasterDetail(docId, docName, statusCd, sortName, pageSize, pageOffset);
            List<DocumentMasterReponse> documentMasterReponses = documentMasterData.stream().map(DocumentMasterReponse::new).collect(Collectors.toList());
            if (documentMasterReponses.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(documentMasterReponses, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("DocumentMasterServiceImpl >> findDocumentMasterDetails : {}", ex);
            throw new BusPassException("DocumentMasterServiceImpl", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .isSuccess(false)
                .build();
    }

    @Override
    public DocumentMasterReponse findDocumentMasterById(Integer docId) {
        try {
            List<Object[]> documentMasterData = documentMasterRepo.getDocumentMasterDetailByDocId(docId);
            List<DocumentMasterReponse> documentMasterReponses = documentMasterData.stream().map(DocumentMasterReponse::new).collect(Collectors.toList());
            if (documentMasterReponses.size() > 0) {
                return documentMasterReponses.get(0);
            }
        } catch (Exception ex) {
            log.error("DocumentMasterServiceImpl >> findDocumentMasterById : {}", ex);
            throw new BusPassException("DocumentMasterServiceImpl >> findDocumentMasterById", false, ex.getMessage());
        }
        return null;
    }

    @Transactional
    @Override
    public BusPassResponse deleteDocumentMasterDetails(Integer docId, String employeeId) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            documentMasterRepo.deleteDocumentMasterDetails(docId, employeeId);
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Document details deleted Successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside DocumentMasterServiceImpl >> deleteDocumentMasterDetails : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }

    }

    @Override
    public List<DocumentMasterDD> ddDocumentMasterDetails() {
        List<Object[]> documentMasterData = documentMasterRepo.findDDDocumentMasterDetails();
        if (documentMasterData.size() > 0) {
            List<DocumentMasterDD> documentMasterDDS = documentMasterData.stream().map(DocumentMasterDD::new).collect(Collectors.toList());
            return documentMasterDDS;
        }
        return null;
    }


    private DocumentMasterEntity convertDocumentMasterCreateRequestToEntity(DocumentMasterCreateRequest documentMasterCreateRequest) {
        DocumentMasterEntity documentMasterEntity = new DocumentMasterEntity();

        documentMasterEntity.setDocName(documentMasterCreateRequest.getDocName());
        documentMasterEntity.setRemark(documentMasterCreateRequest.getRemark());
        documentMasterEntity.setStatusCd(documentMasterCreateRequest.getStatusCd());
        documentMasterEntity.setCreatedUserId(documentMasterCreateRequest.getEmployeeId());
        return documentMasterEntity;
    }
}
