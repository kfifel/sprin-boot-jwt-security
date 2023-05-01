package com.spring.spring.repository;

import com.spring.spring.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeById(int id);
}
