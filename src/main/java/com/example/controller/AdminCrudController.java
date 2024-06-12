package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.models.Employee;
import com.example.service.AdminCrudService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminCrudController {

    @Autowired
    private AdminCrudService adminCrudService;

    @GetMapping("/read")
    public List<Employee> read() {
        return adminCrudService.getAllEmployees();
    }

    @PostMapping("/add")
    public void add(@RequestBody Employee e) {
        adminCrudService.addEmployee(e);
    }

    @GetMapping("/readOne/{employeeId}")
    public Optional<Employee> readOne(@PathVariable Long employeeId) {
        return adminCrudService.getEmployeeById(employeeId);
    }

    @PutMapping("/update/{employeeId}")
    public Employee update(@PathVariable Long employeeId, @RequestBody Employee employeeNew) {
        return adminCrudService.updateEmployee(employeeId, employeeNew);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void delete(@PathVariable Long employeeId) {
        adminCrudService.deleteEmployee(employeeId);
    }
}
