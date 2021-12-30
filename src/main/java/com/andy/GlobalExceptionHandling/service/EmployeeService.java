package com.andy.GlobalExceptionHandling.service;

import com.andy.GlobalExceptionHandling.customeException.BusinessException;
import com.andy.GlobalExceptionHandling.entity.Employee;
import com.andy.GlobalExceptionHandling.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public List<Employee> findAllEmployees() {
        try{
            List<Employee> empList = repository.findAll();
            if(empList.isEmpty()){
                throw new BusinessException("604", "There is no data to show");
            }
            return empList;
        }catch (Exception e){
            throw new BusinessException("605", "Something went wrong while fetching the data");
        }
    }

    public Employee saveEmployee(Employee employee) {

            if(employee.getName().isEmpty() || employee.getName().isBlank() || employee.getName().length()==0) {
                throw new BusinessException("601", "Please insert proper name.");
            }
            try{
                return repository.save(employee);
        }catch (IllegalArgumentException e) {
            throw new BusinessException("602", "Given employee name is incorrect " + e.getMessage());
        }catch (Exception e){
            throw new BusinessException("603", "Something went wrong " + e.getMessage());
        }
    }

    public Employee getById(Long empid) {
            if(empid == null) {
                throw new BusinessException("608", "Employee id is null. ");
            }
        try{
            return repository.findById(empid).get();
        }catch (IllegalArgumentException e){
            throw new BusinessException("606", "Employee id is null. Please give employee id" + e.getMessage());
        }catch (NoSuchElementException e){
            throw new BusinessException("607", "given employee id doesn't exist " + e.getMessage());
        }
    }

    public void deleteEmployee(Long empid) {
        try{
            repository.deleteById(empid);
        }catch (IllegalArgumentException e){
        throw new BusinessException("606", "Employee id is null. Please give employee id" + e.getMessage());
        }catch (NoSuchElementException e){
        throw new BusinessException("607", "given employee id doesn't exist " + e.getMessage());
        }
    }

    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }
}
