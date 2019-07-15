package com.example.employeepostgres.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployeeCreationResponse {

  private Long id;
  private String url;
}
