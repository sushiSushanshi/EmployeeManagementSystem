package com.EmployeeManagement.dto;

import com.EmployeeManagement.entity.Department;
import lombok.Data;

@Data
public class EmployeeDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private Department department;
}
