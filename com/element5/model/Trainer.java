package com.element5.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MappedSuperclass;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import java.util.List;

/**
 * This is Trainer POJO class
 * This class extends Employee and holds the data types of trainer
 *
 */
@Entity
@Table(name = "trainer")
public class Trainer extends Employee {

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "joining_date")
    private String dateOfJoining;

    @Column(name = "experience")
    private int experience; 

    @ManyToMany(targetEntity = Trainee.class, cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "trainer_trainee",
              joinColumns = {@JoinColumn(name= "trainer_id")})             
    private List<Trainee> trainee;

    public Trainer() {}

    public Trainer(int id, String name, long mobileNumber, String email, String designation, String dateOfBirth,
                   String projectName, String dateOfJoining, int experience) {    
        super(id, name, mobileNumber, email, designation, dateOfBirth); 
        this.projectName = projectName;
        this.dateOfJoining = dateOfJoining;
        this.experience = experience;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getJoiningDate() {
        return dateOfJoining;
    }

    public void setJoiningDate(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Trainee> getTraineeDetails() {
        return trainee;
    }

    public void setTraineeDetails(List<Trainee> trainee) {
        this.trainee = trainee;
    }

    @Override
    public String toString() {     
        return ("Trainee's Id:"+getId() 
                + "\n" + "Trainee's Name:" + getName()  
                + "\n" + "Trainee's MobileNumber:" + getMobileNumber() 
                + "\n" + "Trainee's Email:" + getEmail()  
                + "\n" + "Trainee's Designation:" + getDesignation() 
                + "\n" + "Trainee's BirthDate:" + getBirthDate() 
                + "\n" + "Trainee's Project Name:" + getProjectName() 
                + "\n" + "Trainee's experience:" + getExperience()  
                + "\n" + "Trainee's JoiningDate:" + getJoiningDate() + "\n");
    }
}