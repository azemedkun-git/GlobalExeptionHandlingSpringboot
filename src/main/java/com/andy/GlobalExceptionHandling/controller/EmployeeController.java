package com.andy.GlobalExceptionHandling.controller;

import com.andy.GlobalExceptionHandling.entity.Employee;
import com.andy.GlobalExceptionHandling.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/code")
public class EmployeeController {
    private final EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        System.out.println("Getting all employees");
        return service.findAllEmployees();
    }
}
