package com.example.demo.common;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleException(Exception e){

        APIResponse apiResponse = new APIResponse();
        apiResponse.setError(e);
        apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(apiResponse);
    }
//
//    @ExceptionHandler
//    public ResponseEntity handleBadRequestException(BadRequestException e){
//
//        APIResponse apiResponse = new APIResponse();
//        apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//        apiResponse.setError("js");
//
//        return ResponseEntity.status(400).body(apiResponse);
//    }

    @ExceptionHandler
    public ResponseEntity handleAccessDeniedException(AccessDeniedException e){

        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }



}
