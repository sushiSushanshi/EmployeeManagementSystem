package com.EmployeeManagement.service.impl;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee updateEmployee = getEmployeeById(id);
        updateEmployee.setName(employee.getName());
        updateEmployee.setAccessRole(employee.getAccessRole());
        updateEmployee.setAddress(employee.getAddress());
        updateEmployee.setDepartment(employee.getDepartment());
        updateEmployee.setDesignation(employee.getDesignation());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setPhoneNumber(employee.getPhoneNumber());
        employeeRepository.save(updateEmployee);
        return updateEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
