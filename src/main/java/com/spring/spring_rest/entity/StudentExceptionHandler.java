package com.spring.spring_rest.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {

        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        
        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Invalid data. Only integers are accepted");
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        
        Map<String, String> err = new HashMap<>();
        
        // Extract every field error and its custom validation message
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            err.put(error.getField(), error.getDefaultMessage());
        });
        
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    
}