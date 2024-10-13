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

@Table(name = "bus_stop_master")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusStopMasterEntity extends AuditEnabledEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_stop_id")
    private Integer busStopId;

    @Column(name = "routes_id")
    private Integer routesId;

    @Column(name = "bus_stop_name")
    private String busStopName;

    @Column(name = "bus_stop_no")
    private String busStopNo;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status_cd")
    private String statusCd;
}
