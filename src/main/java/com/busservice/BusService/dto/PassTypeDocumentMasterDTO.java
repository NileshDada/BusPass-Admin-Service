package com.busservice.BusService.dto;

import com.busservice.BusService.response.DocumentMasterReponse;
import com.busservice.BusService.response.PassTypeMasterReponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassTypeDocumentMasterDTO {

    PassTypeMasterReponse passTypeMasterReponse = new PassTypeMasterReponse();
    DocumentMasterReponse documentMasterReponse = new DocumentMasterReponse();

    public PassTypeDocumentMasterDTO(Object[] objects) {
        passTypeMasterReponse.setPassTypeId(Integer.parseInt(String.valueOf(objects[0])));
        passTypeMasterReponse.setPassTypeName(String.valueOf(objects[1]));
        passTypeMasterReponse.setPassTypeDescription(String.valueOf(objects[2]));
        passTypeMasterReponse.setPassTypeEndDate(String.valueOf(objects[3]));
        passTypeMasterReponse.setPassTypeCollectionLocation(String.valueOf(objects[4]));
        passTypeMasterReponse.setPassTypeAmount(String.valueOf(objects[5]));

        documentMasterReponse.setDocId(Integer.parseInt(String.valueOf(objects[6])));
        documentMasterReponse.setDocName(String.valueOf(objects[7]));
    }
}
