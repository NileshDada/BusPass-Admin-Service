package com.busservice.BusService.response.dropdown;

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
public class RoutesMasterDD {
    Integer routesId;
    String routesName;

    public RoutesMasterDD(Object[] objects)
    {
        this.routesId = Integer.parseInt(String.valueOf(objects[0]));
        this.routesName = String.valueOf(objects[1]);
    }
}
