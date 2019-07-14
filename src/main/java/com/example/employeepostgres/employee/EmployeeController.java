package com.example.employeepostgres.employee;

import com.example.employeepostgres.employee.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public EmployeeDTO getEmployeeById(Long employeeId){
    return employeeService.getEmployeeById(employeeId);
  }

}
