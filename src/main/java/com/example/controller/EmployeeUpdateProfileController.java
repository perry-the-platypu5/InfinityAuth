package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Employee;
import com.example.models.Employee;
import com.example.service.EmployeeUpdateProfileService;
@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeUpdateProfileController {
    private final EmployeeUpdateProfileService employeeService;

    public EmployeeUpdateProfileController(EmployeeUpdateProfileService employeeService) {
        this.employeeService = employeeService;
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployeeProfile(@PathVariable Long employeeId,
                                                          @RequestBody Employee updatedEmployee) {
        Employee updatedProfile = employeeService.updateEmployeeProfile(employeeId, updatedEmployee);
        return ResponseEntity.ok(updatedProfile);
    }

    @GetMapping("/readOne/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employee);
    }
}

