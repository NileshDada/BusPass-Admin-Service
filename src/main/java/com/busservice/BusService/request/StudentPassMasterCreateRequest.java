package com.busservice.BusService.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudentPassMasterCreateRequest {

    @Schema(example = "1", description = "This field is used for Student id")
    private Integer custId;

    @Schema(example = "1", description = "This field is used for Student pass type Id")
    private Integer passTypeId;

    @Schema(example = "2024-10-10", description = "This field is used for Student pass start date")
    private String studPassCreatedDate;

    @Schema(example = "2024-10-10", description = "This field is used for Student pass expiry dates")
    private String studPassExpiryDate;

    @Schema(example = "1", description = "This field is used for Student start bus stop id")
    private Integer routesId;

    @Schema(example = "1", description = "This field is used for Student start bus stop id")
    private Integer fromBusStopId;

    @Schema(example = "4", description = "This field is used for Student destination bus stop id")
    private Integer toBusStopId;

    @Schema(example = "400", description = "This field is used for Student pass amount")
    private String studPassAmount;

    @Schema(example = "Pending", description = "This field is used for Student pass amount paid status")
    private String studPassAmountPaidStatus;

    @Schema(example = "VVPS", description = "This field is used for everyday school name")
    private String studSchoolName;

    @Schema(example = "Pune", description = "This field is used for school address")
    private String studSchoolAddresss;

    @Schema(example = "Yes", description = "This field is used for  school autonomous")
    private String studSchoolAutonomus;

    @Schema(example = "UDI122", description = "This field is used for  school udise no")
    private String studSchoolUdiseNo;

    @Schema(example = "2024-10-10", description = "This field is used for everyday school start timing")
    private String schoolEveryDayStartTiming;

    @Schema(example = "2024-10-10", description = "This field is used for everyday school end timing")
    private String schoolEveryDayEndTiming;

    @Schema(example = "MCA", description = "This field is used for student course name")
    private String studCourseName;

    @Schema(example = "1", description = "This field is used for student class name")
    private String studClassName;

    @Schema(example = "10", description = "This field is used for student roll no")
    private String studRollNo;

    @Schema(example = "Pending", description = "This field is used for Student Pass status")
    private String studPassStatus;

    @Schema(example = "This is remark", description = "This field is used for language remark")
    private String remark;

    @Schema(example = "A", description = "This field is used for role status")
    private String statusCd;

    @Schema(example = "KPI", description = "This field is used for Created User Id")
    private String employeeId;
}
