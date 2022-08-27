package com.element5.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.Period;

import com.element5.model.Trainer;
import com.element5.model.Trainee;
import com.element5.dao.TrainerDaoImpl;
import com.element5.dao.TraineeDaoImpl;

/**
 * This class is used to store, edit, update, remove and access the database of trainers and trainees
 *
 */
public class EmployeeServiceImpl implements EmployeeService { 

    int id;
    String employeeId;
    String name;
    long mobileNumber;
    String email;
    String designation;
    String dateOfBirth;
    String projectName;
    String taskName;
    String passOutYear;
    String collegeName;
    String dateOfJoining;
    int experience;
    
    static TrainerDaoImpl trainerDao = new TrainerDaoImpl();
    static TraineeDaoImpl traineeDao = new TraineeDaoImpl(); 
    

    /**
     * This method is used to add informations about a trainer in trainer list
     *
     * @param employeeId, trainee parameters are passed to insert the trainer details in the list
     *
     */
    public void addTrainer(int id, String employeeId, String name,long mobileNumber, String email, String designation,
                           String dateOfBirth, String projectName, String dateOfJoining, int experience) {
                           
         Trainer trainer = new Trainer(id, employeeId, name, mobileNumber, email, designation, dateOfBirth, 
                                       projectName, dateOfJoining, experience);
                                      
         trainerDao.insertIntoTrainer(trainer);
        
     }
     
     public String generatedId() {
      
         int id +=1;
         String employeeId = "E5" + id;
         return employeeId;
     }
} 
   
    

    

   