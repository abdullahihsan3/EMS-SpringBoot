package com.abdullah.springboot.crud.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeRestExceptionHandler{
    // add exception handling code here
        //ExceptionHandler for Id
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.NOT_FOUND);

    }
    //Exception Hanlder For All Responses
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
