package com.busservice.BusService.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private Integer custId;
    private Integer roleId;
    private String roleName;
    private String custName;
    private String custEmailId;

    public LoginResponse(Object[] objects) {
        this.custId = Integer.parseInt(String.valueOf(objects[0]));
        this.roleId = Integer.parseInt(String.valueOf(objects[1]));
        this.roleName = String.valueOf(objects[2]);
        this.custName = objects[3] +" "+objects[4]+ " "+objects[5];
        this.custEmailId = String.valueOf(objects[6]);
    }

}
