package com.example.demo.service;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public String addEmployee(EmployeeDTO employeeDTO) {
        // Validate input data
        if (!employeeMapper.isValidEmployee(employeeDTO)) {
            return "Invalid employee data";
        }


        Employee employee = employeeMapper.dtoToEntity(employeeDTO);





        return "Employee added successfully";
    }
}
