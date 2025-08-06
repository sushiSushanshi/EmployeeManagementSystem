package com.EmployeeManagement.service.impl;

import com.EmployeeManagement.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    void createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
