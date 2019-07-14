package com.example.employeepostgres.employee;

import com.example.employeepostgres.employee.entity.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  Optional<Employee> findById(Long i);
}
