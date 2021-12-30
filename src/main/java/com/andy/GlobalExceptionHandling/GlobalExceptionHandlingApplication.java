package com.andy.GlobalExceptionHandling;

import com.andy.GlobalExceptionHandling.entity.Employee;
import com.andy.GlobalExceptionHandling.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlobalExceptionHandlingApplication implements CommandLineRunner {
    @Autowired
    private EmployeeRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(GlobalExceptionHandlingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repo.save(new Employee("Andualem"));
        repo.save(new Employee("John"));
        repo.save(new Employee("Smith"));
        repo.save(new Employee("Lyn"));
        repo.save(new Employee("Josh"));
    }
}
