package com.busservice.BusService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassTypeDocumentMasterReponse {

    private Integer passTypeDocId;
    private Integer passTypeId;
    private String passTypeName;
    private String passTypeDescription;
    private String passTypeEndDate;
    private String passTypeCollectionLocation;
    private String passTypeAmount;
    private Integer docId;
    private String docName;

    private String remark;
    private String statusCd;

    public PassTypeDocumentMasterReponse(Object[] objects){
        passTypeDocId=Integer.parseInt(String.valueOf(objects[0]));

        passTypeId=Integer.parseInt(String.valueOf(objects[1]));
        passTypeName=String.valueOf(objects[2]);
        passTypeDescription=String.valueOf(objects[3]);
        passTypeEndDate=String.valueOf(objects[4]);
        passTypeCollectionLocation=String.valueOf(objects[5]);
        passTypeAmount=String.valueOf(objects[6]);

        docId=Integer.parseInt(String.valueOf(objects[7]));
        docName=String.valueOf(objects[8]);

        remark=String.valueOf(objects[9]);
        statusCd=String.valueOf(objects[10]);
    }
}
