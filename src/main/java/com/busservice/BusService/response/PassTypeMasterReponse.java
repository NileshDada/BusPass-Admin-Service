package com.busservice.BusService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassTypeMasterReponse {

    private Integer passTypeId;
    private String passTypeName;
    private String passTypeDescription;
    private String passTypeEndDate;
    private String passTypeCollectionLocation;
    private String passTypeAmount;
    private String remark;
    private String statusCd;

    public PassTypeMasterReponse(Object[] objects){
        passTypeId=Integer.parseInt(String.valueOf(objects[0]));
        passTypeName=String.valueOf(objects[1]);
        passTypeDescription=String.valueOf(objects[2]);
        passTypeEndDate=String.valueOf(objects[3]);
        passTypeCollectionLocation=String.valueOf(objects[4]);
        passTypeAmount=String.valueOf(objects[5]);
        remark=String.valueOf(objects[6]);
        statusCd=String.valueOf(objects[7]);
    }
}
