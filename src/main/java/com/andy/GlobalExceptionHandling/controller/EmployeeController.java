package com.andy.GlobalExceptionHandling.controller;

import com.andy.GlobalExceptionHandling.customeException.BusinessException;
import com.andy.GlobalExceptionHandling.customeException.ControllerException;
import com.andy.GlobalExceptionHandling.entity.Employee;
import com.andy.GlobalExceptionHandling.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
public class EmployeeController {
    private final EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        System.out.println("Getting all employees");
        List<Employee> listOfEmp = service.findAllEmployees();
        return new ResponseEntity<List<Employee>>(listOfEmp, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        try{
            Employee savedEmp = service.saveEmployee(employee);
            return new ResponseEntity<Employee>(savedEmp, HttpStatus.CREATED);
        }catch (BusinessException e){ //Handle exceptions thrown by the Business exception handler
            return new ResponseEntity<ControllerException>(new ControllerException(e.getErrorCode(), e.getErrorMessage()), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<ControllerException>(new ControllerException("611", "Something went wrong in the controller"), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/emp/{empid}")
    public ResponseEntity<?>getEmpById(@PathVariable("empid") Long empid){
        try{
            Employee empRetrived = service.getById(empid);
            return new ResponseEntity<Employee>(empRetrived, HttpStatus.OK);
        }catch (BusinessException e){ //Handle exceptions thrown by the Business exception handler
            return new ResponseEntity<ControllerException>(new ControllerException(e.getErrorCode(), e.getErrorMessage()), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<ControllerException>(new ControllerException("612", "Something went wrong in the controller"), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("empid") Long empid){
        service.deleteEmployee(empid);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    @PostMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee savedEmp = service.updateEmployee(employee);
        return new ResponseEntity<Employee>(savedEmp, HttpStatus.CREATED);
    }
}
