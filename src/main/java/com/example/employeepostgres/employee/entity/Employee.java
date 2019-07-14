package com.example.employeepostgres.employee.entity;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Employee {

  @Id
  private Long id;

  private String firstName;
  private String lastName;
}
