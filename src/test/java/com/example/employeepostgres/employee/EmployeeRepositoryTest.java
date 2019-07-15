package com.example.employeepostgres.employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.employeepostgres.employee.entity.Employee;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmployeeRepositoryTest {

  @Autowired private EmployeeRepository employeeRepository;

  @Test
  void should_get_employee_when_find_by_id_given_employee_id() {

    // given
    Long employeeId = 1l;
    Employee employee = Employee.builder().id(1l).firstName("Chan").lastName("Suttichujit").build();
    employeeRepository.save(employee);

    // when
    Optional<Employee> resultEmployee = employeeRepository.findById(1l);

    // then
    assertTrue(resultEmployee.isPresent());
    assertEquals(employee, resultEmployee.get());
  }

  @Test
  void should_get_employee_with_id_when_save_given_employee() {

    // given
    Employee employee = Employee.builder()
        .firstName("firstName")
        .lastName("lastName")
        .build();

    // when
    Employee resultEmployee = employeeRepository.save(employee);

    // then
    assertEquals(new Long(1l), resultEmployee.getId());
  }
}
