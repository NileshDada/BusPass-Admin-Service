package com.busservice.BusService.response;

import com.busservice.BusService.utils.DateTimeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportStudentPassMasterReponse {
    private Integer reportStudPassId;
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
    private Integer schoolId;
    private String schoolName;
    private String schoolAddress;
    private String schoolAutonomus;
    private String schoolIdentificationNumber;
    private String schoolEveryDayStartTiming;
        private String schoolEveryDayEndTiming;
    private String studCourseName;
    private String studClassName;
    private String studRollNo;
    private String studPassStatus;


    private String custAddress;
    private String custMobileNo;
    private String custEmailId;
    private String custGender;
    private String custDateOfBirth;
    private String remark;
    private String statusCd;

    public ReportStudentPassMasterReponse(Object[] objects) {

        this.reportStudPassId=Integer.parseInt(String.valueOf(objects[0]));
        this.studPassId=Integer.parseInt(String.valueOf(objects[1]));
        this.studPassFormNo=String.valueOf(objects[2]);
        this.custId=Integer.parseInt(String.valueOf(objects[3]));
        this.custFirstName=String.valueOf(objects[4]);
        this.custMiddleName=String.valueOf(objects[5]);
        this.custLastName=String.valueOf(objects[6]);
        this.passTypeId=Integer.parseInt(String.valueOf(objects[7]));
        this.passTypeName=String.valueOf(objects[8]);
        this.passTypeDescription=String.valueOf(objects[9]);

        if(null!=objects[10]) {
            this.passTypeEndDate = DateTimeUtils.extractDateInDDMMYYY(String.valueOf(objects[10]));
        }


        this.passTypeCollectionLocation=String.valueOf(objects[11]);
        this.passTypeAmount=String.valueOf(objects[12]);
        this.passTypeAgeLimit=String.valueOf(objects[13]);

        if(null!=objects[14]) {
            this.studPassCreatedDate = DateTimeUtils.extractDateInDDMMYYY(String.valueOf(objects[14]));
        }
        if(null!=objects[15]) {
            this.studPassExpiryDate = DateTimeUtils.extractDateInDDMMYYY(String.valueOf(objects[15]));
        }
        this.routesId=Integer.parseInt(String.valueOf(objects[16]));
        this.routesName=String.valueOf(objects[17]);
        this.routesStartLocation=String.valueOf(objects[18]);
        this.routesEndLocation=String.valueOf(objects[19]);
        this.fromBusStopId=Integer.parseInt(String.valueOf(objects[20]));
        this.fromBusStopName=String.valueOf(objects[21]);
        this.fromBusStopNo=String.valueOf(objects[22]);
        this.toBusStopId=Integer.parseInt(String.valueOf(objects[23]));
        this.toBusStopName=String.valueOf(objects[24]);
        this.toBusStopNo=String.valueOf(objects[25]);
        this.studPassAmount=String.valueOf(objects[26]);
        this.studPassAmountPaidStatus=String.valueOf(objects[27]);
        this.schoolId=Integer.parseInt(String.valueOf(objects[28]));

        this.schoolName=String.valueOf(objects[29]);
        this.schoolIdentificationNumber=String.valueOf(objects[30]);
        this.schoolAddress=String.valueOf(objects[31]);
        this.schoolAutonomus=String.valueOf(objects[32]);

        this.schoolEveryDayStartTiming=String.valueOf(objects[33]);
        this.schoolEveryDayEndTiming=String.valueOf(objects[34]);
        this.studCourseName=String.valueOf(objects[35]);
        this.studClassName=String.valueOf(objects[36]);
        this.studRollNo=String.valueOf(objects[37]);
        this.studPassStatus=String.valueOf(objects[38]);

        this.custAddress=String.valueOf(objects[39]);
        this.custMobileNo=String.valueOf(objects[40]);
        this.custEmailId=String.valueOf(objects[41]);
        this.custGender=String.valueOf(objects[42]);

        if(null!=objects[43]) {
            this.custDateOfBirth = DateTimeUtils.extractOnlyDateInDDMMYYY(String.valueOf(objects[43]));
        }
        this.remark = String.valueOf(objects[44]);
        this.statusCd = String.valueOf(objects[45]);
    }
}
