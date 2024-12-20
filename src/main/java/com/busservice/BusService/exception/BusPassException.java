package com.busservice.BusService.exception;

import lombok.Data;

@Data
public class BusPassException extends RuntimeException {

    private static final long serialVersionUID  = 1L;
    private final String sourceClass;
    private final boolean isSuccess;
   public BusPassException(String sourceClass, boolean isSuccess, String details) {
        super(details);
        this.sourceClass = sourceClass;
        this.isSuccess = isSuccess;
    }
}
