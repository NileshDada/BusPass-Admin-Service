package com.busservice.BusService.response.dropdown;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassTypeMasterDD {

    private Integer passTypeId;
    private String passTypeName;

    public PassTypeMasterDD(Object[] objects){
        passTypeId=Integer.parseInt(String.valueOf(objects[0]));
        passTypeName=String.valueOf(objects[1]);
    }
}
