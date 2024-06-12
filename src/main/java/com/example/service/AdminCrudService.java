package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Employee;
import com.example.repo.AdminCrudRepository;

@Service
public class AdminCrudService {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Employee> getAllEmployees() {
        return adminCrudRepository.findAll();
    }
    
    public void addEmployee(Employee e) {
        Employee newEmployee = new Employee();
        newEmployee.setEmployeename(e.getEmployeename());
        newEmployee.setEmployeeId(e.getEmployeeId());
        newEmployee.setDateOfJoining(e.getDateOfJoining());
        newEmployee.setGender(e.getGender());
        newEmployee.setWorkEmail(e.getWorkEmail());
        newEmployee.setMobileNumber(e.getMobileNumber());
        newEmployee.setWorkCity(e.getWorkCity());
        newEmployee.setWorkState(e.getWorkState());
        newEmployee.setDesignation(e.getDesignation());
        newEmployee.setDepartment(e.getDepartment());
        newEmployee.setRole(e.getRole());
        newEmployee.setSalaryid(e.getSalaryid());
        newEmployee.setAdminId(e.getAdminId());
        adminCrudRepository.save(newEmployee);
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {
        return adminCrudRepository.findById(employeeId);
    }

    public Employee updateEmployee(Long employeeId, Employee employeeNew) {
        Optional<Employee> employeeOld = adminCrudRepository.findById(employeeId);
        if (employeeOld.isPresent()) {
            Employee oldEmployee = employeeOld.get();
            oldEmployee.setEmployeename(employeeNew.getEmployeename());
            oldEmployee.setPersonalEmail(employeeNew.getPersonalEmail());
            oldEmployee.setWorkCity(employeeNew.getWorkCity());
            oldEmployee.setWorkState(employeeNew.getWorkState());
            oldEmployee.setDepartment(employeeNew.getDepartment());
            oldEmployee.setDesignation(employeeNew.getDesignation());
            oldEmployee.setAdminId(employeeNew.getAdminId());
            oldEmployee.setRole(employeeNew.getRole());
            return adminCrudRepository.save(oldEmployee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }
    }

    public void deleteEmployee(Long employeeId) {
        adminCrudRepository.deleteById(employeeId);
    }
}
