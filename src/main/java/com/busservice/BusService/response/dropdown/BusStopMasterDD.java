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
public class BusStopMasterDD {
    Integer busStopId;
    String busStopName;

    public BusStopMasterDD(Object[] objects)
    {
        this.busStopId = Integer.parseInt(String.valueOf(objects[0]));
        this.busStopName = String.valueOf(objects[2]) + "-"+String.valueOf(objects[1]);
    }
}
