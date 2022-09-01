package com.element5.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;

/**
 * This is the Employee POJO class
 * This class is used to hold the data types of Employee
 *
 */
@MappedSuperclass
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobilenumber")
    private long mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "designation")
    private String designation;

    @Column(name = "dateofbirth") 
    private String dateOfBirth;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Employee() {}

    public Employee(int id, String name, long mobileNumber, String email, String designation, String dateOfBirth) {

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
  
    public void setId(int id) {
       this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }
  
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBirthDate() {
        return dateOfBirth;
    }

    public void setBirthDate(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 
    public void setIsDeleted(boolean isDeleted) {
      this.isDeleted = isDeleted;
    }
    
    public boolean getIsDeleted() {
      return isDeleted;
    }
}
        
    