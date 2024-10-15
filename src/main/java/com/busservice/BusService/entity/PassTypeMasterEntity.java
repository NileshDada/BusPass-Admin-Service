package com.busservice.BusService.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Table(name = "pass_type_master")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassTypeMasterEntity extends AuditEnabledEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pass_type_id")
    private Integer passTypeId;

    @Column(name = "pass_type_name")
    private String passTypeName;

    @Column(name = "pass_type_description")
    private String passTypeDescription;

    @Column(name = "pass_type_end_date")
    private Instant passTypeEndDate;

    @Column(name = "pass_type_collection_location")
    private String passTypeCollectionLocation;

    @Column(name = "pass_type_amount")
    private String passTypeAmount;

    @Column(name = "pass_type_age_limit")
    private String passTypeAgeLimit;


    @Column(name = "remark")
    private String remark;

    @Column(name = "status_cd")
    private String statusCd;
}
