package com.example.SpringMVCNoSQL.controller;

import com.example.SpringMVCNoSQL.dto.EmployeeRequestDto;
import com.example.SpringMVCNoSQL.model.Employee;
import com.example.SpringMVCNoSQL.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    Employee getEmployeeByID(@PathVariable("id") Integer id){
        return employeeService.getEmployeeByID(id);
    }

    @PostMapping("/employees")
    Employee saveEmployeeDetails(@RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.saveEmployee(employeeRequestDto);
    }

    @PutMapping("/employees")
    Employee updateEmployeeDetails(@RequestBody EmployeeRequestDto employeeRequestDto){

        var emp = employeeService.updateEmployee(employeeRequestDto);
        System.out.println(emp.getEmail());
        return emp;

    }

    @DeleteMapping("/employees/{id}")
    String deleteEmployeeByID(@PathVariable("id") Integer id){
        return employeeService.deleteEmployeeByID(id);
    }

    @DeleteMapping("/employees")
    String deleteAllEmployees(){
        return employeeService.deleteAllEmployees();
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e){
        return e.getMessage();
    }
}
