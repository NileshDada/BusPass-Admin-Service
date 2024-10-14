package com.busservice.BusService.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.Instant;

@Data
public class PassTypeMasterCreateRequest {

    @Schema(example = "1", description = "This field is used for routes id")
    private Integer passTypeId;

    @Schema(example = "Monthly Pass", description = "This field is used for bus stop name")
    private String passTypeName;

    @Schema(example = "This is monthly pass", description = "This field is used for routes end location name")
    private String passTypeDescription;

    @Schema(example = "2023-01-01", description = "This field is used for pass type validity")
    private String passTypeEndDate;

    @Schema(example = "This is collected in Hinjawadi", description = "This field is used for routes end location name")
    private String passTypeCollectionLocation;

    @Schema(example = "400.50", description = "This field is used for pass type amount")
    private String passTypeAmount;
    
    @Schema(example = "This is remark", description = "This field is used for language remark")
    private String remark;

    @Schema(example = "A", description = "This field is used for role status")
    private String statusCd;

    @Schema(example = "KPI", description = "This field is used for Created User Id")
    private String employeeId;
}
