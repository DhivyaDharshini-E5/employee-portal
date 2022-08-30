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

    private int id;
    private String name;
    private long mobileNumber;
    private String email;
    private int age;
    private String designation;
    private String dateOfBirth;
    private String projectName;
    private String taskName;
    private String passOutYear;
    private String collegeName;
    private String dateOfJoining;
    private int experience;
    
    static TrainerDaoImpl trainerDao = new TrainerDaoImpl();
    static TraineeDaoImpl traineeDao = new TraineeDaoImpl(); 
    

    /**
     * This method is used to add informations about a trainer in trainer list
     *
     * @param employeeId, trainee parameters are passed to insert the trainer details in the list
     *
     */
    public void addTrainer(int id, String name, long mobileNumber, String email, String designation,
                           String dateOfBirth, String projectName, String dateOfJoining, int experience) {
                           
         Trainer trainer = new Trainer(id, name, mobileNumber, email, designation, dateOfBirth, 
                                       projectName, dateOfJoining, experience);
                                      
         trainerDao.insertIntoTrainer(trainer);
        
     }

    public void addTrainee(int id, String name, long mobileNumber, String email, String designation,
                           String dateOfBirth, String taskName, String passOutYear, String collegeName) {
                           
         Trainee trainee = new Trainee(id, name, mobileNumber, email, designation, dateOfBirth, 
                                       taskName, passOutYear, collegeName);
                                      
         traineeDao.insertIntoTrainee(trainee);
        
     }

      public int calculateAge(String dateOfBirth) { 
         LocalDate birthDate = LocalDate.parse(dateOfBirth);
         LocalDate today = LocalDate.now();
         age = Period.between(birthDate, today).getYears();
         return age;
      }

      public Trainer viewTrainerDetailsById(int trainerId) {
          return trainerDao.showTrainerDetailsById(trainerId);
      }

      public Trainee viewTraineeDetailsById(int traineeId) {
          return traineeDao.showTraineeDetailsById(traineeId);
      }

      public List<Trainee> viewAllTraineeDetails() {
          return traineeDao.showAllTraineeDetails();
      }

      public List<Trainer> viewAllTrainerDetails() {
          return trainerDao.showAllTrainerDetails();
      }

      public String updateTrainerDetailsById(int trainerId, Trainer updatedTrainerDetails) {
          return trainerDao.modifyTrainerDetailsById(trainerId, updatedTrainerDetails);
      }

      public String updateTraineeDetailsById(int traineeId, Trainee updatedTraineeDetails) {
          return traineeDao.modifyTraineeDetailsById(traineeId, updatedTraineeDetails);
      }

      public String deleteTrainerDetailsById(int trainerId) {
         return trainerDao.removeTrainerDetails(trainerId);
      }
     
      public String deleteTraineeDetailsById(int traineeId) {
         return traineeDao.removeTraineeDetails(traineeId);
      }
     
      public String changeTrainerDetailsById(int trainerId, Trainer trainer) {
         return trainerDao.modifyTrainerDetailsById(trainerId, trainer);
      }

      public String changeTraineeDetailsById(int traineeId, Trainee trainee) {
         return traineeDao.modifyTraineeDetailsById(traineeId, trainee);
      } 
} 
   
    

    

   