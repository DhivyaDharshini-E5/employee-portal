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
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name = "trainer")
public class Trainer extends Employee {

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "joining_date")
    private String dateOfJoining;

    @Column(name = "experience")
    private int experience; 

    @OneToMany(targetEntity = Trainee.class, cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "trainerid")
    private List<Trainee> traineeDetails; 

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

        return traineeDetails;
    }

    public void setTraineeDetails(List<Trainee> traineeDetails) {

        this.traineeDetails = traineeDetails;
    }

    public String toString() {
     
        return ("Trainer's Id:"+getId() +"\n"+ "Trainer's Name:" + getName() +"\n"+ "Trainer's MobileNumber:" + getMobileNumber() +"\n"+
                "Trainer's Email:" + getEmail()+"\n"+ "Trainer's Designation:" + getDesignation() +"\n"+
                "Trainer's BirthDate:" + getBirthDate() +"\n"+"Trainer's project Name:" + getProjectName() +"\n"+
                "Trainer's Joining Date:" + getJoiningDate() +"\n"+ "Trainer's Experience:" + getExperience()+"\n"+
                 "Trainee's Details:" + getTraineeDetails());
    }
}