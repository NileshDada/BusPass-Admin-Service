package com.busservice.BusService.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolInformationMasterReponse {
    private Integer schoolId;
    private String schoolIdentificationNumber;
    private String schoolName;
    private String schoolAddress;
    private String schoolAutonomus;
    private String schoolEveryDayStartTiming;
    private String schoolEveryDayEndTiming;
    private String remark;
    private String statusCd;

    public SchoolInformationMasterReponse(Object[] objects) {
        this.schoolId=Integer.parseInt(String.valueOf(objects[0]));
        this.schoolIdentificationNumber=String.valueOf(objects[1]);
        this.schoolName=String.valueOf(objects[2]);
        this.schoolAddress=String.valueOf(objects[3]);
        this.schoolAutonomus=String.valueOf(objects[4]);
        this.schoolEveryDayStartTiming=String.valueOf(objects[5]);
        this.schoolEveryDayEndTiming=String.valueOf(objects[6]);
        this.remark = String.valueOf(objects[7]);
        this.statusCd = String.valueOf(objects[8]);
    }
}
