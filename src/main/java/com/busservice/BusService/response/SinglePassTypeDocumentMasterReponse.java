package com.busservice.BusService.response;

import com.busservice.BusService.utils.DateTimeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SinglePassTypeDocumentMasterReponse {
    private Integer passTypeDocId;
    private Integer passTypeId;
    private String passTypeName;
    private String passTypeDescription;
    private String passTypeEndDate;
    private String passTypeCollectionLocation;
    private String passTypeAmount;
    private String passTypeAgeLimit;
    private Integer docId;
    private String docName;
    private String remark;
    private String statusCd;

    public SinglePassTypeDocumentMasterReponse(Object[] objects){

        passTypeDocId=Integer.parseInt(String.valueOf(objects[0]));
        passTypeId=Integer.parseInt(String.valueOf(objects[1]));
        passTypeName=String.valueOf(objects[2]);

        passTypeDescription=String.valueOf(objects[3]);
        if(null!=objects[4]) {
            this.passTypeEndDate = DateTimeUtils.extractDateInDDMMYYY(String.valueOf(objects[4]));
        }

        passTypeCollectionLocation=String.valueOf(objects[5]);
        passTypeAmount=String.valueOf(objects[6]);
        passTypeAgeLimit=String.valueOf(objects[7]);
        docId=Integer.parseInt(String.valueOf(objects[8]));
        docName=String.valueOf(objects[9]);
        remark=String.valueOf(objects[10]);
        statusCd=String.valueOf(objects[11]);
    }
}
