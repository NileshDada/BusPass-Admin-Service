package com.busservice.BusService.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PassTypeDocumentMasterUpdateRequest {

    @Schema(example = "1", description = "This field is used for pass document type id")
    Integer passTypeDocId;

    @Schema(example = "1", description = "This field is used for pass type id")
    private Integer passTypeId;

    @Schema(example = "1", description = "This field is used for document id")
    private Integer docId;

    @Schema(example = "This is remark", description = "This field is used for language remark")
    private String remark;

    @Schema(example = "A", description = "This field is used for role status")
    private String statusCd;

    @Schema(example = "KPI", description = "This field is used for Created User Id")
    private String employeeId;
}
