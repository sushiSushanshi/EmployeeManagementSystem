package com.EmployeeManagement.service.impl;

import com.EmployeeManagement.dto.EmployeeDTO;
import com.EmployeeManagement.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
