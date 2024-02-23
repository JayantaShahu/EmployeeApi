package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class EmployeeTax {
    private String employeeCode;
    private String firstName;
    private String lastName;
    private Date dateOfJoining;
    private double salary;



}
