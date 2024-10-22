package com.busservice.BusService.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomerMasterUpdateRequest {

    @Schema(example = "1", description = "This field is used for Customer Id")
    private Integer custId;

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

    @Schema(example = "This is remark", description = "This field is used for remark")
    private String remark;

    @Schema(example = "A", description = "This field is used for status")
    private String statusCd;

    @Schema(example = "KPI", description = "This field is used for Created User Id")
    private String employeeId;
}