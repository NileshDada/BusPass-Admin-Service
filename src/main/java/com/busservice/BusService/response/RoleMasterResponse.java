package com.busservice.BusService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleMasterResponse {

    private Integer roleId;
    private String roleName;
    private String remark;
    private String statusCd;


    public RoleMasterResponse(Object[] objects) {
        roleId = Integer.parseInt(String.valueOf(objects[0]));
        roleName = String.valueOf(objects[1]);
        remark = String.valueOf(objects[2]);
        statusCd = String.valueOf(objects[3]);
    }
}
