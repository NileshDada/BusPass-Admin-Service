package com.busservice.BusService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusStopMasterReponse {

    private Integer busStopId;
    private String busStopName;
    private String busStopNo;

    private Integer routesId;
    private String routesName;
    private String routesStartLocation;
    private String routesEndLocation;

    private String remark;
    private String statusCd;

    public BusStopMasterReponse(Object[] objects) {
        this.busStopId = Integer.parseInt(String.valueOf(objects[0]));
        this.busStopName = String.valueOf(objects[1]);
        this.busStopNo = String.valueOf(objects[2]);
        this.routesId = Integer.parseInt(String.valueOf(objects[3]));
        this.routesName = String.valueOf(objects[4]);
        this.routesStartLocation = String.valueOf(objects[5]);
        this.routesEndLocation = String.valueOf(objects[6]);
        this.remark = String.valueOf(objects[7]);
        this.statusCd = String.valueOf(objects[8]);
    }
}
