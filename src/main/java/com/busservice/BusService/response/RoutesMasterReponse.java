package com.busservice.BusService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutesMasterReponse {

    private Integer routesId;
    private String routesName;
    private String routesStartLocation;
    private String routesEndLocation;
    private String remark;
    private String statusCd;

    public RoutesMasterReponse(Object[] objects) {
        routesId = Integer.parseInt(String.valueOf(objects[0]));
        routesName = String.valueOf(objects[1]);
        routesStartLocation = String.valueOf(objects[2]);
        routesEndLocation = String.valueOf(objects[3]);
        remark = String.valueOf(objects[4]);
        statusCd = String.valueOf(objects[5]);
    }
}
