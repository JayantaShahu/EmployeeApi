package com.example.demo.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Employee {
    //@NotNull
    private Long employeeId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @NotEmpty
    private List<@Pattern(regexp="(^$|[0-9]{10})") String> phoneNumbers;

    @NotBlank
    private String doj;

    @NotNull
    @Min(0)
    private Double salary;
    private String employeeCode;

    public Date getDateOfJoining() {
        return getDateOfJoining();

    }

    public String getEmployeeCode() {
        return employeeCode;
    }
}
