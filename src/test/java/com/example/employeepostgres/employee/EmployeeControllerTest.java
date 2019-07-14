package com.example.employeepostgres.employee;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.example.employeepostgres.employee.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

  @Mock
  private EmployeeService employeeService;

  @InjectMocks
  private EmployeeController employeeController;

  @Test
  public void should_get_employee_when_get_employee_by_id_given_employee_id() {

    //given
    Long employeeId = 1l;
    EmployeeDTO employeeDTO = EmployeeDTO.builder()
        .firstName("firstName")
        .lastName("lastName")
        .build();
    when(employeeService.getEmployeeById(employeeId)).thenReturn(employeeDTO);

    //when
    EmployeeDTO actualEmployeeDTO = employeeController.getEmployeeById(employeeId);

    //then
    EmployeeDTO expectEmployeeDTO = EmployeeDTO.builder()
        .firstName("firstName")
        .lastName("lastName")
        .build();
    assertEquals(expectEmployeeDTO, actualEmployeeDTO);

  }


}