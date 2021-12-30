package com.andy.GlobalExceptionHandling.repository;

import com.andy.GlobalExceptionHandling.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
