package com.example.employeepostgres.employee;

import com.example.employeepostgres.employee.dto.EmployeeCreationResponse;
import com.example.employeepostgres.employee.dto.EmployeeDTO;
import com.example.employeepostgres.employee.entity.Employee;
import com.example.employeepostgres.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired private EmployeeRepository employeeRepository;

  public EmployeeDTO getEmployeeById(Long employeeId) {
    Employee employee =
        employeeRepository
            .findById(employeeId)
            .orElseThrow(
                () -> new ResourceNotFoundException("Customer id " + employeeId + " is not found"));

    return EmployeeDTO.builder()
        .firstName(employee.getFirstName())
        .lastName(employee.getLastName())
        .build();
  }

  public EmployeeCreationResponse createEmployee(EmployeeDTO employeeDTO) {

    Employee savedEmployee = employeeRepository.save(Employee.builder()
        .firstName(employeeDTO.getFirstName())
        .lastName(employeeDTO.getLastName())
        .build());

    Long employeeId = savedEmployee.getId();

    return EmployeeCreationResponse.builder()
        .url("/employees/"+ employeeId)
        .id(employeeId)
        .build();
  }
}
