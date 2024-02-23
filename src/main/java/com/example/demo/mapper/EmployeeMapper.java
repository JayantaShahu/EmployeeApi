package com.example.demo.mapper;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "phoneNumbers", source = "phoneNumbers")
    Employee dtoToEntity(EmployeeDTO employeeDTO);

    default boolean isValidEmail(String email) {

        return email != null && email.contains("@") && email.contains(".");
    }

    default boolean isValidPhoneNumber(String phoneNumber) {

        return phoneNumber != null && phoneNumber.length() >= 10;
    }

    default boolean isValidSalary(double salary) {
        return salary > 0;
    }

    default boolean isValidEmployee(EmployeeDTO employeeDTO) {

        return employeeDTO != null &&
                employeeDTO.getEmployeeID() != null &&
                employeeDTO.getFirstName() != null &&
                employeeDTO.getLastName() != null &&
                employeeDTO.getEmail() != null && isValidEmail(employeeDTO.getEmail()) &&
                employeeDTO.getPhoneNumbers() != null && employeeDTO.getPhoneNumbers().stream().allMatch(this::isValidPhoneNumber) &&
                employeeDTO.getDoj() != null &&
                isValidSalary(employeeDTO.getSalary());
    }
}
