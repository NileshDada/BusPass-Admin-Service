package com.busservice.BusService.service.serviceimpl;

import com.busservice.BusService.exception.BusPassException;
import com.busservice.BusService.repository.RoleMasterRepo;
import com.busservice.BusService.response.BusPassResponse;
import com.busservice.BusService.response.BusStopMasterReponse;
import com.busservice.BusService.response.RoleMasterResponse;
import com.busservice.BusService.service.RoleMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleMasterServiceImpl implements RoleMasterService {

    @Autowired
    RoleMasterRepo roleMasterRepo;



    @Override
    public BusPassResponse findRoleDetails(Integer roleId, String roleName, String statusCd, Pageable requestPageable) {
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

            Integer totalCount = roleMasterRepo.getRoleMasterDetailsCount(roleId, roleName, statusCd);
            List<Object[]> languageMasterData = roleMasterRepo.getRoleMasterDetail(roleId, roleName, statusCd, sortName, pageSize, pageOffset);
            List<RoleMasterResponse> roleMasterReponses = languageMasterData.stream().map(RoleMasterResponse::new).collect(Collectors.toList());
            if (roleMasterReponses.size() > 0) {
                return BusPassResponse.builder()
                        .isSuccess(true)
                        .responseData(new PageImpl<>(roleMasterReponses, requestPageable, totalCount))
                        .build();
            }
        } catch (Exception ex) {
            log.error("RoleMasterServiceImpl >> findRoleDetails : {}", ex);
            throw new BusPassException("RoleMasterServiceImpl", false, ex.getMessage());
        }
        return BusPassResponse.builder()
                .isSuccess(false)
                .build();
    }

}
