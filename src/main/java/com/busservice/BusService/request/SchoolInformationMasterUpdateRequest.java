package com.busservice.BusService.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SchoolInformationMasterUpdateRequest {

    @Schema(example = "1", description = "This field is used for  school id")
    private Integer schoolId;

    @Schema(example = "VVPS", description = "This field is used for everyday school name")
    private String schoolName;

    @Schema(example = "Pune", description = "This field is used for school address")
    private String schoolAddresss;

    @Schema(example = "Yes", description = "This field is used for  school autonomous")
    private String schoolAutonomus;


    @Schema(example = "2024-10-10", description = "This field is used for everyday school start timing")
    private String schoolEveryDayStartTiming;

    @Schema(example = "2024-10-10", description = "This field is used for everyday school end timing")
    private String schoolEveryDayEndTiming;

    @Schema(example = "This is remark", description = "This field is used for language remark")
    private String remark;

    @Schema(example = "A", description = "This field is used for role status")
    private String statusCd;

    @Schema(example = "KPI", description = "This field is used for Created User Id")
    private String employeeId;
}
