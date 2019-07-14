package com.example.employeepostgres.employee;

import com.example.employeepostgres.employee.dto.EmployeeDTO;
import com.example.employeepostgres.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public EmployeeDTO getEmployeeById(int employeeId) {
    Employee employee = employeeRepository.findById(employeeId);

    return EmployeeDTO.builder()
        .firstName(employee.getFirstName())
        .lastName(employee.getLastName())
        .build();
  }
}
