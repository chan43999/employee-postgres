package com.example.employeepostgres.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResourceNotFoundResponse {

  private String error;
  private String message;
}
