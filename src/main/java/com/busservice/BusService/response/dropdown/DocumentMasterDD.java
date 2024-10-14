package com.busservice.BusService.response.dropdown;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentMasterDD {

    private Integer docId;
    private String docName;

    public DocumentMasterDD(Object[] objects){
        docId=Integer.parseInt(String.valueOf(objects[0]));
        docName=String.valueOf(objects[1]);
    }
}
