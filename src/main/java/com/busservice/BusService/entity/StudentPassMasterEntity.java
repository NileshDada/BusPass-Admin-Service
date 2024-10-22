package com.busservice.BusService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Table(name = "student_pass_master")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPassMasterEntity extends AuditEnabledEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stud_pass_id")
    private Integer studPassId;

    @Column(name = "stud_pass_form_no")
    private String studPassFormNo;

    @Column(name = "cust_id")
    private Integer custId;

    @Column(name = "pass_type_id")
    private Integer passTypeId;

    @Column(name = "stud_pass_created_date")
    private Instant studPassCreatedDate;

    @Column(name = "stud_pass_expire_date")
    private Instant studPassExpiryDate;

    @Column(name = "routes_id")
    private Integer routesId;

    @Column(name = "from_bus_stop_id")
    private Integer fromBusStopId;

    @Column(name = "to_bus_stop_id")
    private Integer toBusStopId;

    @Column(name = "stud_pass_amount")
    private String studPassAmount;

    @Column(name = "stud_pass_amount_paid_status")
    private String studPassAmountPaidStatus;

    @Column(name = "school_id")
    private Integer schoolId;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_address")
    private String schoolAddresss;

    @Column(name = "school_automomus")
    private String schoolAutonomus;

    @Column(name = "school_identification_number")
    private String schoolIdentificationNumber;

    @Column(name = "school_everyday_start_timing")
    private Instant schoolEveryDayStartTiming;

    @Column(name = "school_everyday_end_timing")
    private Instant schoolEveryDayEndTiming;

    @Column(name = "stud_course_name")
    private String studCourseName;

    @Column(name = "stud_class_name")
    private String studClassName;

    @Column(name = "stud_roll_no")
    private String studRollNo;

    @Column(name = "stud_pass_status")
    private String studPassStatus;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status_cd")
    private String statusCd;
}