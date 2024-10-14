package com.busservice.BusService.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DocumentMasterCreateRequest {

    @Schema(example = "Adhar Card", description = "This field is used for Document name")
    private String docName;

    @Schema(example = "This is remark", description = "This field is used for Document remark")
    private String remark;

    @Schema(example = "A", description = "This field is used for role status")
    private String statusCd;

    @Schema(example = "KPI", description = "This field is used for Created User Id")
    private String employeeId;
}
