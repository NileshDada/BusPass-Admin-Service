package com.busservice.BusService.response.dropdown;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolInfoMasterDD {

    private Integer schoolId;
    private String schoolName;

    public SchoolInfoMasterDD(Object[] objects){
        schoolId=Integer.parseInt(String.valueOf(objects[0]));
        schoolName=String.valueOf(objects[1]);
    }
}
