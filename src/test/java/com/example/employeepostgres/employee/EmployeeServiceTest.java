package com.example.employeepostgres.employee;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.example.employeepostgres.employee.dto.EmployeeDTO;
import com.example.employeepostgres.employee.entity.Employee;
import com.example.employeepostgres.exception.ResourceNotFoundException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

  @Mock private EmployeeRepository employeeRepository;

  @InjectMocks private EmployeeService employeeService;

  @Test
  void should_get_employee_when_get_employee_by_id_given_employee_id() {

    // given
    Long employeeId = 1l;
    Employee employee =
        Employee.builder().id(1l).firstName("firstName").lastName("lastName").build();
    when(employeeRepository.findById(1l)).thenReturn(Optional.of(employee));

    // when
    EmployeeDTO actualEmployeeDTO = employeeService.getEmployeeById(employeeId);

    // then
    EmployeeDTO expectEmployeeDTO =
        EmployeeDTO.builder().firstName("firstName").lastName("lastName").build();
    assertEquals(expectEmployeeDTO, actualEmployeeDTO);
  }

  @Test
  void should_throw_resource_not_found_exception_when_get_employee_by_id_given_employee_id() {

    // given
    Long employeeId = 1l;
    when(employeeRepository.findById(1l)).thenReturn(Optional.empty());

    assertThrows(
        ResourceNotFoundException.class,
        () -> employeeService.getEmployeeById(employeeId),
        "Customer id " + employeeId + " is not found");
  }
}
