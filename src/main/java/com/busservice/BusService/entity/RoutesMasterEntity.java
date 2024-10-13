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

@Table(name = "routes_master")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutesMasterEntity extends AuditEnabledEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routes_id")
    private Integer routesId;

    @Column(name = "routes_name")
    private String routesName;

    @Column(name = "routes_start_location")
    private String routesStartLocation;

    @Column(name = "routes_end_location")
    private String routesEndLocation;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status_cd")
    private String statusCd;

}
