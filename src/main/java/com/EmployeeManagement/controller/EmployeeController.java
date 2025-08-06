package com.EmployeeManagement.controller;

import com.EmployeeManagement.dto.APIResponse;
import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.exceptions.EmployeeNotFoundException;
import com.EmployeeManagement.service.impl.EmployeeService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return ResponseEntity.ok("Employee successfully created with id: "+employee.getId());
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse<List<Employee>>> getALlEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        APIResponse<List<Employee>> response = new APIResponse<>();
        response.setData(employeeList);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Employee>> getEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        APIResponse<Employee> response = new APIResponse<>();
        response.setData(employee);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<APIResponse<Employee>> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        APIResponse<Employee> response = new APIResponse<>();
        response.setMessage("Employee data successfully updated");
        return ResponseEntity.ok().body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<String>> deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        if(employee != null) {
            employeeService.deleteEmployee(id);
            APIResponse<String> response = new APIResponse<>();
            response.setMessage("successfully deleted employee with id: "+id);
            return ResponseEntity.ok().body(response);
        }
        else
            throw new EmployeeNotFoundException();

    }
}
