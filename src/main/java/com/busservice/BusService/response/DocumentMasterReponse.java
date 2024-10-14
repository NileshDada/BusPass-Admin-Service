package com.busservice.BusService.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentMasterReponse {

    private Integer docId;
    private String docName;
    private String remark;
    private String statusCd;

    public DocumentMasterReponse(Object[] objects){
        docId=Integer.parseInt(String.valueOf(objects[0]));
        docName=String.valueOf(objects[1]);
        remark=String.valueOf(objects[2]);
        statusCd=String.valueOf(objects[3]);
    }
}
