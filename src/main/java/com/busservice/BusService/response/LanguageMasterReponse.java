package com.busservice.BusService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageMasterReponse {

    private Integer langId;
    private String langName;
    private String remark;
    private String statusCd;

    public LanguageMasterReponse(Object[] objects){
        langId=Integer.parseInt(String.valueOf(objects[0]));
        langName=String.valueOf(objects[1]);
        remark=String.valueOf(objects[2]);
        statusCd=String.valueOf(objects[3]);
    }
}
