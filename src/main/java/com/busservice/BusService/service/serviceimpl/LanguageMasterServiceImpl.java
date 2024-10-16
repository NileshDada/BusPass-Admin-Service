package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.entity.LanguageMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.LanguageMasterRepo;
import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.request.LanguageMasterUpdateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.LanguageMasterReponse;
import com.busservice.BusService.response.dropdown.LanguageMasterDD;
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
public class LanguageMasterServiceImpl implements LanguageMasterService {

    @Autowired
    private LanguageMasterRepo languageMasterRepo;


    @Override
    public BusPassResponse saveLanguageMaster(LanguageMasterCreateRequest languageMasterCreateRequest) {
        Optional<LanguageMasterEntity> optionalDepartmentEntity = languageMasterRepo.findByLangNameEqualsIgnoreCase(languageMasterCreateRequest.getLangName());
        if (optionalDepartmentEntity.isPresent()) {
            log.error("Inside LanguageMasterServiceImpl >> saveLanguageMaster()");
            throw new BusPassException("LanguageMasterServiceImpl Class", false, "Language name already exist");
        }

        LanguageMasterEntity languageMasterEntity = convertLanguageMasterCreateRequestToEntity(languageMasterCreateRequest);
        try {
            languageMasterRepo.save(languageMasterEntity);

            return BusPassResponse.builder()
                    .isSuccess(true)
                    .responseMessage(BusPassConstant.RECORD_SUCCESS)
                    .build();
        } catch (Exception ex) {
            log.error("Inside LanguageMasterServiceImpl >> saveLanguageMaster()");
            throw new BusPassException("LanguageMasterServiceImpl", false, ex.getMessage());
        }
    }

    @Transactional
    @Override
    public BusPassResponse updateLanguageMaster(LanguageMasterUpdateRequest languageMasterUpdateRequest) {

        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            languageMasterRepo.updateLanguageMasterDetails(languageMasterUpdateRequest.getLangId(), languageMasterUpdateRequest.getLangName(), languageMasterUpdateRequest.getRemark(), languageMasterUpdateRequest.getEmployeeId());
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Language updated successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside LanguageMasterServiceImpl >> updateLanguageMaster : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }

    }

    @Override
    public BusPassResponse findLanguageMasterDetails(Integer langId, String langName, String statusCd, Pageable requestPageable) {
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

            Integer totalCount = languageMasterRepo.getLanguageMasterDetailsCount(langId, langName, statusCd);
            List<Object[]> languageMasterData = languageMasterRepo.getLanguageMasterDetail(langId, langName, statusCd, sortName, pageSize, pageOffset);
            List<LanguageMasterReponse> languageMasterReponses = languageMasterData.stream().map(LanguageMasterReponse::new).collect(Collectors.toList());
            if (languageMasterReponses.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(languageMasterReponses, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("LanguageMasterServiceImpl >>getAllLanguageMasterDetails : {}", ex);
            throw new BusPassException("LanguageMasterServiceImpl", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .isSuccess(false)
                .build();
    }

    @Override
    public LanguageMasterReponse findLanguageMasterByLangId(Integer langId) {
        try {
            List<Object[]> languageMasterData = languageMasterRepo.getLanguageMasterByLangId(langId);
            List<LanguageMasterReponse> languageMasterReponses = languageMasterData.stream().map(LanguageMasterReponse::new).collect(Collectors.toList());
            if (languageMasterReponses.size() > 0) {
                return languageMasterReponses.get(0);
            }
        } catch (Exception ex) {
            log.error("LanguageMasterServiceImpl >>findLanguageMasterByLangId() : {}", ex);
            throw new BusPassException("LanguageMasterServiceImpl", false, ex.getMessage());
        }
        return null;
    }

    @Transactional
    @Override
    public BusPassResponse deleteLanguageMasterDetails(Integer langId) {
        BusPassResponse busPassResponse = new BusPassResponse();
        try {
            languageMasterRepo.deleteLanguageMasterDetails(langId);
            busPassResponse.setSuccess(true);
            busPassResponse.setResponseMessage("Language details deleted Successfully");
            return busPassResponse;
        } catch (Exception ex) {
            log.error("Inside LanguageMasterServiceImpl >> deleteLanguageMasterDetails : {}", ex);
            return BusPassResponse.builder()
                    .isSuccess(false)
                    .build();
        }

    }

    @Override
    public BusPassResponse findDDLanguageMasterDetails() {
        List<Object[]> languageMasterData = languageMasterRepo.findDDLanguageMasterDetails();
        if (languageMasterData.size() > 0) {
            List<LanguageMasterDD> languageMasterReponses = languageMasterData.stream().map(LanguageMasterDD::new).collect(Collectors.toList());
            return BusPassResponse.builder().isSuccess(true).responseData(languageMasterReponses).build();
        }
        return BusPassResponse.builder().isSuccess(false).build();
    }


    private LanguageMasterEntity convertLanguageMasterCreateRequestToEntity(LanguageMasterCreateRequest languageMasterCreateRequest) {
        LanguageMasterEntity languageMasterEntity = new LanguageMasterEntity();

        languageMasterEntity.setLangName(languageMasterCreateRequest.getLangName());
        languageMasterEntity.setRemark(languageMasterCreateRequest.getRemark());
        languageMasterEntity.setStatusCd(languageMasterCreateRequest.getStatusCd());
        languageMasterEntity.setCreatedUserId(languageMasterCreateRequest.getEmployeeId());
        return languageMasterEntity;
    }
}
