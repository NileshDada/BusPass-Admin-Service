package com.busservice.BusService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentPassMasterReponse {

    private Integer studPassId;
    private String studPassFormNo;
    private Integer custId;
    private String custFirstName;
    private String custMiddleName;
    private String custLastName;
    private Integer passTypeId;
    private String passTypeName;
    private String passTypeDescription;
    private String passTypeEndDate;
    private String passTypeCollectionLocation;
    private String passTypeAmount;
    private String passTypeAgeLimit;

    private String studPassCreatedDate;
    private String studPassExpiryDate;
    private Integer routesId;
    private String routesName;
    private String routesStartLocation;
    private String routesEndLocation;
    private Integer fromBusStopId;
    private String fromBusStopName;
    private String fromBusStopNo;
    private Integer toBusStopId;
    private String  toBusStopName;
    private String toBusStopNo;
    private String studPassAmount;
    private String studPassAmountPaidStatus;
    private String schoolName;
    private String schoolAddresss;
    private String schoolAutonomus;
    private String schoolUdiseNo;
    private String schoolEveryDayStartTiming;
    private String schoolEveryDayEndTiming;
    private String studCourseName;
    private String studClassName;
    private String studRollNo;
    private String studPassStatus;
    private String remark;
    private String statusCd;

    public StudentPassMasterReponse(Object[] objects) {
        this.studPassId=Integer.parseInt(String.valueOf(objects[0]));
        this.studPassFormNo=String.valueOf(objects[1]);
        this.custId=Integer.parseInt(String.valueOf(objects[2]));
        this.custFirstName=String.valueOf(objects[3]);
        this.custMiddleName=String.valueOf(objects[4]);
        this.custLastName=String.valueOf(objects[5]);
        this.passTypeId=Integer.parseInt(String.valueOf(objects[6]));
        this.passTypeName=String.valueOf(objects[7]);
        this.passTypeDescription=String.valueOf(objects[8]);
        this.passTypeEndDate=String.valueOf(objects[9]);
        this.passTypeCollectionLocation=String.valueOf(objects[10]);
        this.passTypeAmount=String.valueOf(objects[11]);
        this.passTypeAgeLimit=String.valueOf(objects[12]);

        this.studPassCreatedDate=String.valueOf(objects[13]);
        this.studPassExpiryDate=String.valueOf(objects[14]);
        this.routesId=Integer.parseInt(String.valueOf(objects[15]));
        this.routesName=String.valueOf(objects[16]);
        this.routesStartLocation=String.valueOf(objects[17]);
        this.routesEndLocation=String.valueOf(objects[18]);
        this.fromBusStopId=Integer.parseInt(String.valueOf(objects[19]));
        this.fromBusStopName=String.valueOf(objects[20]);
        this.fromBusStopNo=String.valueOf(objects[21]);
        this.toBusStopId=Integer.parseInt(String.valueOf(objects[22]));
        this.toBusStopName=String.valueOf(objects[23]);
        this.toBusStopNo=String.valueOf(objects[24]);
        this.studPassAmount=String.valueOf(objects[25]);
        this.studPassAmountPaidStatus=String.valueOf(objects[26]);
        this.schoolName=String.valueOf(objects[27]);
        this.schoolAddresss=String.valueOf(objects[28]);
        this.schoolAutonomus=String.valueOf(objects[29]);
        this.schoolUdiseNo=String.valueOf(objects[30]);
        this.schoolEveryDayStartTiming=String.valueOf(objects[31]);
        this.schoolEveryDayEndTiming=String.valueOf(objects[32]);
        this.studCourseName=String.valueOf(objects[33]);
        this.studClassName=String.valueOf(objects[34]);
        this.studRollNo=String.valueOf(objects[35]);
        this.studPassStatus=String.valueOf(objects[36]);
        this.remark = String.valueOf(objects[37]);
        this.statusCd = String.valueOf(objects[38]);
    }
}
