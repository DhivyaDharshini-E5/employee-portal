package com.element5.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.MappedSuperclass;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import java.util.List;
import java.sql.Date;

@Entity
@Table(name = "trainee")
public class Trainee extends Employee {

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "passoutyear")
    private String passOutYear;

    @Column(name = "college_name")
    private String collegeName;

     @ManyToOne(targetEntity = Trainer.class, cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
     @JoinColumn(name = "trainerid")
     private Trainer trainer;

    
    public Trainee() {}

    public Trainee(int id, String name, long mobileNumber, String email, String designation, String dateOfBirth, 
                   String taskName, String passOutYear, String collegeName) {
    
        super(id, name, mobileNumber, email, designation, dateOfBirth);
        this.taskName = taskName;
        this.passOutYear = passOutYear;
        this.collegeName = collegeName;

    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getPassOutYear() {
        return passOutYear;
    }

    public void setPassOutYear(String passOutYear) {
        this.passOutYear = passOutYear;
    }
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setTrainerDetails(Trainer trainer) {
        this.trainer = trainer;
    }

    public Trainer getTrainerDetails() {
        return trainer;
    }

    public String toString() {
     
        return ("Trainee's Id:"+getId() +"\n"+ "Trainee's Name:" + getName() +"\n"+ "Trainee's MobileNumber:" + getMobileNumber() +"\n"+
                "Trainee's Email:" + getEmail()+"\n"+ "Trainee's Designation:" + getDesignation() +"\n"+
                "Trainee's BirthDate:" + getBirthDate() +"\n"+"Trainee's Task Name:" + getTaskName() +"\n"+
                "Trainee's PassOutYear:" + getPassOutYear() +"\n"+ "Trainee's collegeName:" + getCollegeName()+"\n");
    }
}