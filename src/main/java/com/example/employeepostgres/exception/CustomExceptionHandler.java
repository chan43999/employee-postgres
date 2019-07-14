package com.example.employeepostgres.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ResourceNotFoundResponse> handleResourceNotFoundException(
      ResourceNotFoundException resourceNotFoundException) {

    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(
            ResourceNotFoundResponse.builder()
                .error("Resource not found")
                .message(resourceNotFoundException.getMessage())
                .build());
  }
}
