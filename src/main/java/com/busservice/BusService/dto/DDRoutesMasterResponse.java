package com.busservice.BusService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DDRoutesMasterResponse {
    Integer routesId;
    String routesName;

    public DDRoutesMasterResponse(Object[] objects)
    {
        this.routesId = Integer.parseInt(String.valueOf(objects[0]));
        this.routesName = String.valueOf(objects[1]);
    }
}
