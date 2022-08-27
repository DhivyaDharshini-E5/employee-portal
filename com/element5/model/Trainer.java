package com.element5.model;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Trainer")
public class Trainer extends Employee {

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "joining_date")
    private String dateOfJoining;

    @Column(name = "experience")
    private int experience;
    

    public Trainer() {}

    public Trainer(int id, String employeeId, String name, long mobileNumber,String email, String designation, 
                   String dateOfBirth, String projectName, String dateOfJoining, int experience) {

        super(); 

        this.projectName = projectName;
        this.dateOfJoining = dateOfJoining;
        this.experience = experience;

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName() {
        this.projectName = projectName;
    }

    public String getJoiningDate() {
        return dateOfJoining;
    }

    public void setJoiningDate() {
        this.dateOfJoining = dateOfJoining;
    }
    public int getExperience() {
        return experience;
    }

    public void setExperience() {
        this.experience = experience;
    }
}