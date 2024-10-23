package com.busservice.BusService.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BusStopMasterUpdateRequest {

    @Schema(example = "1", description = "This field is used for bus stop id")
    private Integer busStopId;

    @Schema(example = "1", description = "This field is used for routes id")
    private Integer routesId;

    @Schema(example = "Aadrsha Nager", description = "This field is used for bus stop name")
    private String busStopName;

    @Schema(example = "101", description = "This field is used for routes end location name")
    private String busStopNo;

    @Schema(example = "This is remark", description = "This field is used for language remark")
    private String remark;

    @Schema(example = "A", description = "This field is used for role status")
    private String statusCd;

    @Schema(example = "KPI", description = "This field is used for Created User Id")
    private String employeeId;
}
