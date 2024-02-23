package com.example.demo.API;

import com.example.demo.controller.TaxCalculator;
import com.example.demo.entity.Employee;



import java.util.ArrayList;

import java.util.List;


public class main {
    public static void main(String[] args) {
        // Create TaxCalculator instance
        TaxCalculator taxCalculator = new TaxCalculator();

        // Add employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("001", "John", "Doe", new Date(2023, 4, 16), 750000));
        employees.add(new Employee("002", "Jane", "Smith", new Date(2023, 2, 10), 1200000));

        // Get tax deduction for employees
        taxCalculator.getEmployeesTaxDeduction(employees);
    }
}
