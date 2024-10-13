package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.constant.BusPassConstant;
import com.busservice.BusService.entity.LanguageMasterEntity;
import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.LanguageMasterRepo;
import com.busservice.BusService.request.LanguageMasterCreateRequest;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.service.LanguageMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class LanguageMasterServiceImpl implements LanguageMasterService {

    @Autowired
    private LanguageMasterRepo languageMasterRepo;


    @Override
    public BusPassResponse saveLanguageMaster(LanguageMasterCreateRequest languageMasterCreateRequest) {
        Optional<LanguageMasterEntity> optionalDepartmentEntity = languageMasterRepo.findByLangNameEqualsIgnoreCase(languageMasterCreateRequest.getLangName() );
        if(optionalDepartmentEntity.isPresent()){
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


    private LanguageMasterEntity convertLanguageMasterCreateRequestToEntity(LanguageMasterCreateRequest languageMasterCreateRequest) {
        LanguageMasterEntity languageMasterEntity = new LanguageMasterEntity();

        languageMasterEntity.setLangName(languageMasterCreateRequest.getLangName());
        languageMasterEntity.setRemark(languageMasterCreateRequest.getRemark());
        languageMasterEntity.setStatusCd(languageMasterCreateRequest.getStatusCd());
        languageMasterEntity.setCreatedUserId(languageMasterCreateRequest.getEmployeeId());
        return  languageMasterEntity;
    }
}
