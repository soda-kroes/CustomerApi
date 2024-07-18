package com.java.E1.java_api.controller;


import com.java.E1.java_api.dto.response.StatusResponseDTO;
import com.java.E1.java_api.exception.AlreadyExistException;
import com.java.E1.java_api.exception.BadRequestException;
import com.java.E1.java_api.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex) {
        StatusResponseDTO response = new StatusResponseDTO();
        response.setErrorCode(500);
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.status(500).body(response);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<?> handleAlreadyExistException(AlreadyExistException ex) {
        StatusResponseDTO response = new StatusResponseDTO();
        response.setErrorCode(403);
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.status(409).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
        StatusResponseDTO response = new StatusResponseDTO();
        response.setErrorCode(404);
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.status(404).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException ex) {
        StatusResponseDTO response = new StatusResponseDTO();
        response.setErrorCode(400);
        response.setErrorMessage(ex.getMessage());
        return ResponseEntity.status(400).body(response);
    }

}