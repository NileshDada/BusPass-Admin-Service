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

@Table(name = "school_information_master")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolInformationMasterEntity extends AuditEnabledEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Integer schoolId;

    @Column(name = "school_identification_number")
    private String schoolIdentificationNumber;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_address")
    private String schoolAddresss;

    @Column(name = "school_automomus")
    private String schoolAutonomus;

    @Column(name = "school_everyday_start_timing")
    private Instant schoolEveryDayStartTiming;

    @Column(name = "school_everyday_end_timing")
    private Instant schoolEveryDayEndTiming;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status_cd")
    private String statusCd;
}