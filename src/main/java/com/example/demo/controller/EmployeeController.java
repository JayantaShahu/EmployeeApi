package com.example.demo.controller;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    private List<Employee> employees = new ArrayList<>();

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) {

        if (employeeDTO == null || !isValidEmployee(employeeDTO)) {
            return ResponseEntity.badRequest().body("Invalid employee data");
        }


        Employee employee = new Employee(
                employeeDTO.getEmployeeID(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getPhoneNumbers(),
                employeeDTO.getDoj(),
                employeeDTO.getSalary()
        );


        employees.add(employee);


        return ResponseEntity.status(HttpStatus.CREATED).body("Employee added successfully");
    }

    private boolean isValidEmployee(EmployeeDTO employeeDTO) {

        return employeeDTO.getEmployeeID() != null &&
                employeeDTO.getFirstName() != null &&
                employeeDTO.getLastName() != null &&
                employeeDTO.getEmail() != null &&
                employeeDTO.getPhoneNumbers() != null &&
                employeeDTO.getDoj() != null &&
                employeeDTO.getSalary() > 0;
    }
}
