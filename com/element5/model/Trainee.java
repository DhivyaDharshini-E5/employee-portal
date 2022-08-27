package com.element5.model;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Trainee")
public class Trainee extends Employee {

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "passoutyear")
    private String passOutYear;

    @Column(name = "college_name")
    private String collegeName;
    

    public Trainee() {}

    public Trainee(int id, String employeeId, String name, long mobileNumber,String email, String designation, 
                   String dateOfBirth, String taskName, String passOutYear, String collegeName) {

        super(); 

        this.taskName = taskName;
        this.passOutYear = passOutYear;
        this.collegeName = collegeName;

    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName() {
        this.taskName = taskName;
    }

    public String getPassOutYear() {
        return passOutYear;
    }

    public void setPassOutYear() {
        this.passOutYear = passOutYear;
    }
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName() {
        this.collegeName = collegeName;
    }
}