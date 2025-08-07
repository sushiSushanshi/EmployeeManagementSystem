package com.EmployeeManagement.service.impl;

import com.EmployeeManagement.dto.EmployeeDTO;
import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employeeRepository.save(employee);
        EmployeeDTO responseEmployeeDto=modelMapper.map(employee, EmployeeDTO.class);
        return responseEmployeeDto;

    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));
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
