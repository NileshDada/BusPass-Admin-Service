package com.busservice.BusService.request;

import com.busservice.BusService.entity.AuditEnabledEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class CustomerMasterCreateRequest {

    @Schema(example = "Nilesh", description = "This field is used for Customer First Name")
    private String custFirstName;

    @Schema(example = "Sambhaji", description = "This field is used for Customer Middle Name")
    private String custMiddleName;

    @Schema(example = "Jambhulkar", description = "This field is used for Customer Last Name")
    private String custLastName;

    @Schema(example = "Pune", description = "This field is used for Customer ")
    private String custAddress;

  //  @Schema(example = "Pune", description = "This field is used for Customer Photo")
   // private String custPhoto;

    @Schema(example = "111", description = "This field is used for Customer mobile no")
    private String custMobileNo;

    @Schema(example = "Pune", description = "This field is used for Customer email id")
    private String custEmailId;

    @Schema(example = "Male", description = "This field is used for Customer gender")
    private String custGender;

    @Schema(example = "2024-12-13", description = "This field is used for Customer Date of birth")
    private String custDateOfBirth;

    @Schema(example = "Pune", description = "This field is used for Customer login user name")
    private String custLoginUserName;

    @Schema(example = "Pune", description = "This field is used for Customer login password")
    private String custLoginUserPassword;

    @Schema(example = "This is remark", description = "This field is used for remark")
    private String remark;

    @Schema(example = "A", description = "This field is used for status")
    private String statusCd;

    @Schema(example = "KPI", description = "This field is used for Created User Id")
    private String employeeId;
}