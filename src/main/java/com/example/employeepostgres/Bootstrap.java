package com.example.employeepostgres;

import com.example.employeepostgres.employee.EmployeeRepository;
import com.example.employeepostgres.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

  @Autowired private EmployeeRepository employeeRepository;

  @Override
  public void run(String... args) throws Exception {

    employeeRepository.save(
        Employee.builder().id(1l).firstName("Chan").lastName("Suttichujit").build());
  }
}
