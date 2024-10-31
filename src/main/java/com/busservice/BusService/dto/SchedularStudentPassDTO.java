package com.busservice.BusService.dto;

import com.busservice.BusService.entity.AuditEnabledEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@ToString
public class SchedularStudentPassDTO {
    private Integer studPassId;
    private String studPassFormNo;
    private Integer custId;
    private Integer passTypeId;
    private String studPassCreatedDate;
    private String studPassExpiryDate;
    private Integer routesId;
    private Integer fromBusStopId;
    private Integer toBusStopId;
    private String studPassAmount;
    private String studPassAmountPaidStatus;
    private Integer schoolId;
    private String schoolIdentificationNumber;
    private String studCourseName;
    private String studClassName;
    private String studRollNo;
    private String studPassStatus;
    private String remark;
    private String statusCd;
    private String createdDate;
    private String createdUserId;
    private String updatedDate;
    private String updatedUserId;

    public SchedularStudentPassDTO(Object[] objects) {
        this.studPassId = Integer.parseInt(String.valueOf(objects[0]));
        this.studPassFormNo = String.valueOf(objects[1]);
        this.custId = Integer.parseInt(String.valueOf(objects[2]));
        this.passTypeId = Integer.parseInt(String.valueOf(objects[3]));
        this.studPassCreatedDate = String.valueOf(objects[4]);
        this.studPassExpiryDate = String.valueOf(objects[5]);
        this.routesId = Integer.parseInt(String.valueOf(objects[6]));
        this.fromBusStopId = Integer.parseInt(String.valueOf(objects[7]));
        this.toBusStopId = Integer.parseInt(String.valueOf(objects[8]));
        this.studPassAmount = String.valueOf(objects[9]);
        this.studPassAmountPaidStatus = String.valueOf(objects[10]);
        this.schoolId = Integer.parseInt(String.valueOf(objects[11]));
        this.schoolIdentificationNumber = String.valueOf(objects[12]);
        this.studCourseName = String.valueOf(objects[13]);
        this.studClassName = String.valueOf(objects[14]);
        this.studRollNo = String.valueOf(objects[15]);
        this.studPassStatus = String.valueOf(objects[16]);
        this.remark = String.valueOf(objects[17]);
        this.statusCd = String.valueOf(objects[18]);
        this.createdDate = String.valueOf(objects[19]);

        this.createdUserId = String.valueOf(objects[20]);
        this.updatedDate = String.valueOf(objects[21]);
        this.updatedUserId = String.valueOf(objects[22]);
    }
}