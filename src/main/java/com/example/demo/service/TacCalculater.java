package com.example.demo.service;

import com.example.demo.entity.Employee;

import com.example.demo.entity.EmployeeTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class TacCalculater {
    @Autowired
    private boolean employees;

    public double calculateTax(double salary) {
        double tax = 0;
        if (salary <= 250000) {
            tax = 0;
        } else if (salary <= 500000) {
            tax = (salary - 250000) * 0.05;
        } else if (salary <= 1000000) {
            tax = 12500 + (salary - 500000) * 0.1;
        } else {
            tax = 62500 + (salary - 1000000) * 0.2;
        }
        return tax;

    }

    public double calculateCess(double salary) {

        double cess = 0;
        if (salary > 2500000) {
            cess = (salary - 2500000) * 0.02;
        }
        return cess;

    }

    public double calculateTotalSalary(EmployeeTax employee) {

        public double calculateTotalSalary(EmployeeTax employee);
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int currentYear = calendar.get(Calendar.YEAR);

            calendar.setTime(employee.getDateOfJoining());
            int joinYear = calendar.get(Calendar.YEAR);
            int joinMonth = calendar.get(Calendar.MONTH);

            int monthsWorked = (currentYear - joinYear) * 12 + calendar.get(Calendar.MONTH);

            double totalSalary = (employee.getSalary() / 30) * 30 * monthsWorked; // Considering 30 days per month

            return totalSalary;
        }

        public void getEmployeesTaxDeduction (List < Employee > employees) {
            // Loop through employees and calculate tax deduction
            public void getEmployeesTaxDeduction (List < Employee > employees) {
                for (Employee employee : employees) {
                    double totalSalary = calculateTotalSalary(employee);
                    double tax = calculateTax(totalSalary);
                    double cess = calculateCess(totalSalary);

                    System.out.println("Employee Code: " + employee.getEmployeeCode());
                    System.out.println("First Name: " + employee.getFirstName());
                    System.out.println("Last Name: " + employee.getLastName());
                    System.out.println("Yearly Salary: " + totalSalary);
                    System.out.println("Tax Amount: " + tax);
                    System.out.println("Cess Amount: " + cess);
                    System.out.println();
                }
            }
        }
    }
}
