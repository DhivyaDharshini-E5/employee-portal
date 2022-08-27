package com.element5.model;

import javax.persistence.*;

import java.sql.Date;

@MappedSuperclass
public class Employee {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobilenumber")
    private long mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "employeeid")
    private String employeeId;

    @Column(name = "designation")
    private String designation;

    @Column(name = "dateofbirth") 
    private String dateOfBirth;

    public Employee() {}

    public Employee(int id, String employeeId, String name, long mobileNumber,String email, String designation, String dateOfBirth) {

        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.designation = designation;
        this.dateOfBirth = dateOfBirth;
    }
     
    public int getId() {
       return id;
    }
  
    public void setId() {
       this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber() {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }
  
    public void setDesignation() {
        this.designation = designation;
    }

    public String getBirthDate() {
        return dateOfBirth;
    }

    public void setBirthDate() {
        this.dateOfBirth = dateOfBirth;
    }
}
        
    