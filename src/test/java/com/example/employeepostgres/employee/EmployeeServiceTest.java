package com.example.employeepostgres.employee;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.example.employeepostgres.employee.dto.EmployeeDTO;
import com.example.employeepostgres.employee.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

  @Mock
  private EmployeeRepository employeeRepository;

  @InjectMocks
  private EmployeeService employeeService;

  @Test
  void shoudl_get_employee_when_get_employee_by_id_given_employee_id() {

    //given
    int employeeId = 1;
    Employee employee = Employee.builder()
        .id(1l)
        .firstName("firstName")
        .lastName("lastName")
        .build();
    when(employeeRepository.findById(1)).thenReturn(employee);

    //when
    EmployeeDTO actualEmployeeDTO = employeeService.getEmployeeById(employeeId);

    //then
    EmployeeDTO expectEmployeeDTO = EmployeeDTO.builder()
        .firstName("firstName")
        .lastName("lastName")
        .build();
    assertEquals(expectEmployeeDTO, actualEmployeeDTO);

  }

}