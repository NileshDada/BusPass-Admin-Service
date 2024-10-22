package com.busservice.BusService.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMasterReponse {

    private Integer custId;
    private String custFirstName;
    private String custMiddleName;
    private String custLastName;
    private String custAddress;
    private String custMobileNo;
    private String custEmailId;
    private String custGender;
    private String custDateOfBirth;
    private String custLoginUserName;
    private String remark;
    private String statusCd;

    public CustomerMasterReponse(Object[] objects) {
        this.custId = Integer.parseInt(String.valueOf(objects[0]));
        this.custFirstName = String.valueOf(objects[1]);
        this.custMiddleName = String.valueOf(objects[2]);
        this.custLastName = String.valueOf(objects[3]);
        this.custAddress = String.valueOf(objects[4]);
        this.custMobileNo = String.valueOf(objects[5]);
        this.custEmailId = String.valueOf(objects[6]);
        this.custGender = String.valueOf(objects[7]);
        this.custDateOfBirth = String.valueOf(objects[8]);
        this.custLoginUserName=String.valueOf(objects[9]);
        this.remark = String.valueOf(objects[10]);
        this.statusCd = String.valueOf(objects[11]);
    }
}
