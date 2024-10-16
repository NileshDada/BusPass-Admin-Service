package com.busservice.BusService.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LanguageMasterUpdateRequest {


    @Schema(example = "1", description = "This field is used for language Id")
    private Integer langId;

    @Schema(example = "English", description = "This field is used for language name")
    private String langName;

    @Schema(example = "This is remark", description = "This field is used for language remark")
    private String remark;

    @Schema(example = "A", description = "This field is used for role status")
    private String statusCd;

    @Schema(example = "KPI", description = "This field is used for Created User Id")
    private String employeeId;
}
