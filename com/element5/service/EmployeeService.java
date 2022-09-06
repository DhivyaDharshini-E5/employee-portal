package com.element5.service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import java.time.Period;

import com.element5.model.Trainer;
import com.element5.model.Trainee;

/**
 * <h3> EmployeeService </h3>
 * This class has the abstract methods and it is implemented in EmployeeServiceImplementation class
 *
 * @autor Dhivya
 * @version 1.1
 * @since 2022
 *
 */
public interface EmployeeService {

    /**
     * This method is used to add informations about a trainer in trainer list
     *
     * @param Id, trainer parameters are passed to insert the trainer details in the list
     *
     */
    public void addTrainer(int id, String name, long mobileNumber, String email, String designation, String dateOfBirth,
                            String projectName, String dateOfJoining, int experience);
   
    /**
     * This method is used to add informations about a trainee in trainee list
     *
     * @param Id, trainee parameters are passed to insert the trainer details in the list
     *
     */
    public void addTrainee(int id, String name, long mobileNumber, String email, String designation,
                           String dateOfBirth, String taskName, String passOutYear, String collegeName);

    /**
     * This method is used to calculate the age of a employee
     *
     * @param dateofbirth of an employee is passed as a parameter
     *
     * @return age
     *
     */
    //public int calculateAge(String dateOfBirth);

     /**
      * This method is used to view trainer details 
      *
      * @param trainerId is passed as a parameter
      *
      * @return trainer details
      *
      */
     public Trainer viewTrainerDetailsById(int trainerId);

     /**
      * This method is used to view trainee details 
      *
      * @param traineeId is passed as a parameter
      *
      * @return trainee details
      *
      */
      public Trainee viewTraineeDetailsById(int traineeId); 
     
     /**
      * This method is used to view all trainer details
      *
      * @return trainer informations in a list
      */
     public List<Trainer> viewAllTrainerDetails();
     
     /**
      * This method is used to view all trainee details
      *
      * @return trainee informations in a list
      */        
     public List<Trainee> viewAllTraineeDetails(); 

     /**
      * This method is used to update trainer Details
      *
      */      
     public String updateTrainerDetailsById(int trainerId, Trainer trainer);
    
     /**
      * This method is used to update trainee Details
      *
      */    
     public String updateTraineeDetailsById(int traineeId, Trainee trainee);

     /**
      * This method is used to remove trainer Details
      *
      */
     public String deleteTrainerDetailsById(int trainerId);

     /**
      * This method is used to remove trainer Details
      *
      */    
     public String deleteTraineeDetailsById(int traineeId); 
    
     /**
      * This method is used to update details of trainees assigned to trainer in trainer details
      *
      */             
     public String changeTrainerDetailsById(int trainerId, Trainer trainer);
    
     /**
      * This method is used to update details of trainer assigned to trainee in trainee details
      *
      */           
     public String changeTraineeDetailsById(int traineeId, Trainee trainee);
}

