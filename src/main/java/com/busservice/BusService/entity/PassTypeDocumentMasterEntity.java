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

@Table(name = "pass_type_document_master")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassTypeDocumentMasterEntity extends AuditEnabledEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pass_type_doc_id")
    private Integer passTypeDocId;

    @Column(name = "pass_type_id")
    private Integer passTypeId;

    @Column(name = "doc_id")
    private Integer docId;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status_cd")
    private String statusCd;
}