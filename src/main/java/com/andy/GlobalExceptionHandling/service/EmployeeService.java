package com.andy.GlobalExceptionHandling.service;

import com.andy.GlobalExceptionHandling.entity.Employee;
import com.andy.GlobalExceptionHandling.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }
}
