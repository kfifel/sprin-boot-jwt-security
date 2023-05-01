package com.spring.spring.service;

import com.spring.spring.entities.Employee;
import com.spring.spring.exceptions.UserNotFoundException;
import com.spring.spring.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById( int id){
        return employeeRepo.findEmployeeById(id).
                orElseThrow(() -> new UserNotFoundException("there is no user with this id:"+id));
    }

}
