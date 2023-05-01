package com.spring.spring.rest;

import com.spring.spring.entities.Employee;
import com.spring.spring.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees = this.employeeService.getAllEmployee();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") int id){
        Employee employee = this.employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Employee> findEmployee(@RequestBody Employee employee){

        Employee NewEmployee = this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(NewEmployee, HttpStatus.CREATED);
    }
}
