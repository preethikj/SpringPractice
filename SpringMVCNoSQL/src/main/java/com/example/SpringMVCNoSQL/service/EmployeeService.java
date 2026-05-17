package com.example.SpringMVCNoSQL.service;

import com.example.SpringMVCNoSQL.dto.EmployeeRequestDto;
import com.example.SpringMVCNoSQL.model.Employee;
import com.example.SpringMVCNoSQL.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(EmployeeRequestDto employeeRequestDto){
        Employee employee = Employee.builder().id(employeeRequestDto.getId())
                .name(employeeRequestDto.getName())
                .email(employeeRequestDto.getEmail())
                .location(employeeRequestDto.getLocation())
                .build();
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(EmployeeRequestDto employeeRequestDto){
//        Employee employee = Employee.builder().id(employeeRequestDto.getId())
//                .name(employeeRequestDto.getName())
//                .email(employeeRequestDto.getEmail())
//                .location(employeeRequestDto.getLocation())
//                .build();
//        System.out.println(employee);
//        return employeeRepository.save(employee);
        return null;
    }


    public String deleteEmployeeByID(Integer id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Record Deleted"; // Deletion succeeded
        }
        return "No such record found"; // Record didn't exist
    }

    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        return "All employee records deleted..";
    }

    public Employee getEmployeeByID(Integer id) {
        return employeeRepository.findById(id).orElse(new Employee());
    }
}
