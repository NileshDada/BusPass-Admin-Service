package com.busservice.BusService.response.dropdown;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageMasterDD {

    private Integer langId;
    private String langName;

    public LanguageMasterDD(Object[] objects){
        langId=Integer.parseInt(String.valueOf(objects[0]));
        langName=String.valueOf(objects[1]);
    }
}
