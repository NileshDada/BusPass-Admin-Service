package com.busservice.BusService.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RoutesMasterUpdateRequest {

    @Schema(example = "1", description = "This field is used for routes name")
    private Integer routesId;

    @Schema(example = "Pune", description = "This field is used for routes name")
    private String routesName;

    @Schema(example = "Hinjawadi", description = "This field is used for routes start location name")
    private String routesStartLocation;

    @Schema(example = "Shivaji Nagar", description = "This field is used for routes end location name")
    private String routesEndLocation;

    @Schema(example = "This is remark", description = "This field is used for language remark")
    private String remark;

    @Schema(example = "A", description = "This field is used for role status")
    private String statusCd;

    @Schema(example = "KPI", description = "This field is used for Created User Id")
    private String employeeId;
}
