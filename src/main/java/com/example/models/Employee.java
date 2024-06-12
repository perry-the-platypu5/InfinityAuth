package com.example.models;

import java.sql.Date;
import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
	
    @Id
    @Column(unique=true,nullable=false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //Basic details--> Gender, Phone number
    private Long employeeId;
    private String employeename;
    private Date dateOfJoining;
    private String workEmail;
    private String workCity;
    private String workState;
    private String designation;
    private String department;
    private String role; //Admin or employee
    private String salaryid;
    @ManyToOne
    private Employee adminId;
    
    // Personal Details
    private Date dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String bloodGroup;
    private String nationality;

    // Contact Details
    private String mobileNumber;
    private String personalEmail;
    private String address;

    // Banking Info
    private String bankName;
    private String nameAsPerBank;
    private String bankAccountNumber;
    private String panNumber;
    private String bankAccountType;
    private String ifscCode;
    private String pfNumber;
    private String uanNumber;
    
    private boolean deleted;
    private String payBand;
}

