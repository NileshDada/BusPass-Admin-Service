package com.busservice.BusService.exception;

import com.busservice.BusService.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BusPassException.class)
    public final ResponseEntity<Object> handlePMException(BusPassException exception, WebRequest request) {
        ErrorResponse response = ErrorResponse.builder().sourceClass(exception.getSourceClass()).isSuccess(exception.isSuccess()).details(exception.getMessage()).build();
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
