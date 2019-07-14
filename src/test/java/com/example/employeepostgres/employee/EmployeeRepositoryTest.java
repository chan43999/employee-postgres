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
}
