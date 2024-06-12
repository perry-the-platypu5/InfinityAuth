package com.example.service;

import org.springframework.stereotype.Service;

import com.example.models.Employee;
import com.example.repo.AdminCrudRepository ;

@Service
public class EmployeeUpdateProfileService {
    private final AdminCrudRepository  adminCrudRepository;

    public EmployeeUpdateProfileService(AdminCrudRepository  adminCrudRepository) {
        this.adminCrudRepository = adminCrudRepository;
    }

    public Employee updateEmployeeProfile(Long employeeId, Employee updatedEmployee) {
        Employee employee = adminCrudRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + employeeId));

        // Update personal details
        employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        employee.setGender(updatedEmployee.getGender());
        employee.setMaritalStatus(updatedEmployee.getMaritalStatus());
        employee.setBloodGroup(updatedEmployee.getBloodGroup());
        employee.setNationality(updatedEmployee.getNationality());

        // Update contact details
        employee.setMobileNumber(updatedEmployee.getMobileNumber());
        employee.setPersonalEmail(updatedEmployee.getPersonalEmail());
        employee.setAddress(updatedEmployee.getAddress());

        // Update banking info
        employee.setBankName(updatedEmployee.getBankName());
        employee.setNameAsPerBank(updatedEmployee.getNameAsPerBank());
        employee.setBankAccountNumber(updatedEmployee.getBankAccountNumber());
        employee.setPanNumber(updatedEmployee.getPanNumber());
        employee.setBankAccountType(updatedEmployee.getBankAccountType());
        employee.setIfscCode(updatedEmployee.getIfscCode());
        employee.setPfNumber(updatedEmployee.getPfNumber());
        employee.setUanNumber(updatedEmployee.getUanNumber());

        return adminCrudRepository.save(employee);
    }

    public Employee getEmployeeById(Long employeeId) {
        return adminCrudRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + employeeId));
    }
}
