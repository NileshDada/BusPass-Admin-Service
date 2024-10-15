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

@Table(name = "customer_master")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerMasterEntity extends AuditEnabledEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Integer custId;

    @Column(name = "cust_first_name")
    private String custFirstName;

    @Column(name = "cust_middle_name")
    private String custMiddleName;

    @Column(name = "cust_last_name")
    private String custLastName;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_photo")
    private  byte[] custPhoto;

    @Column(name = "cust_mobile_no")
    private String custMobileNo;

    @Column(name = "cust_email_id")
    private String custEmailId;

    @Column(name = "cust_gender")
    private String custGender;

    @Column(name = "cust_dob")
    private Instant custDateOfBirth;

    @Column(name = "cust_login_user_name")
    private String custLoginUserName;

    @Column(name = "cust_login_password")
    private String custLoginUserPassword;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "cust_status")
    private String custStatus;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status_cd")
    private String statusCd;
}