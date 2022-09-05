package com.element5.service;

import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;
import java.time.Period;

import com.element5.model.Trainer;
import com.element5.model.Trainee;
import com.element5.dao.TrainerDaoImpl;
import com.element5.dao.TraineeDaoImpl;

/**
 * <h3> EmployeeServiceImpl </h3>
 *
 * This class has the implementations of abstract methods of Interface EmployeeService and has TrainerDaoImplementation class and 
 * traineeDaoImplementations objects
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
    
    TrainerDaoImpl trainerDao = new TrainerDaoImpl();
    TraineeDaoImpl traineeDao = new TraineeDaoImpl(); 
    
    /**
     * This method is used to add informations about a trainer in trainer list
     *
     * @param employeeId, trainer parameters are passed to insert the trainer details in the list
     *
     */
    @Override
    public void addTrainer(int id, String name, long mobileNumber, String email, String designation,
                           String dateOfBirth, String projectName, String dateOfJoining, int experience) {                           
        Trainer trainer = new Trainer(id, name, mobileNumber, email, designation, dateOfBirth, 
                                       projectName, dateOfJoining, experience);                                     
        trainerDao.insertIntoTrainerTable(trainer);
        
    }
 
    /**
     * This method is used to add informations about a trainee in trainee list
     *
     * @param Id, trainee parameters are passed to insert the trainer details in the list
     *
     */
    @Override
    public void addTrainee(int id, String name, long mobileNumber, String email, String designation,
                           String dateOfBirth, String taskName, String passOutYear, String collegeName) {                          
        Trainee trainee = new Trainee(id, name, mobileNumber, email, designation, dateOfBirth, 
                                       taskName, passOutYear, collegeName);                                      
        traineeDao.insertIntoTraineeTable(trainee);
        
    }

    /**
     * This method is used to calculate the age of a employee
     *
     * @param dateofbirth of an employee is passed as a parameter
     *
     * @return age
     *
     */
    @Override
    public int calculateAge(String dateOfBirth) { 
        LocalDate birthDate = LocalDate.parse(dateOfBirth);
        LocalDate today = LocalDate.now();
        age = Period.between(birthDate, today).getYears();
        return age;
    }

    /**
     *This method is used to view trainer details 
     *
     * @param trainerId is passed as a parameter
     *
     * @return trainer details
     *
     */
    @Override
    public Trainer viewTrainerDetailsById(int trainerId) {
        return trainerDao.showTrainerDetailsById(trainerId);
    }
     
    /**
     *This method is used to view trainee details 
     *
     * @param traineeId is passed as a parameter
     *
     * @return trainee details
     *
     */
    @Override
    public Trainee viewTraineeDetailsById(int traineeId) {
        return traineeDao.showTraineeDetailsById(traineeId);
    }

    /**
     * This method is used to view all trainee details
     *
     * @return trainee informations in a list
     */
    @Override
    public List<Trainee> viewAllTraineeDetails() {
        return traineeDao.showAllTraineeDetails();
    }

    /**
     * This method is used to view all trainer details
     *
     * @return trainer informations in a list
     */
    @Override
    public List<Trainer> viewAllTrainerDetails() {
        return trainerDao.showAllTrainerDetails();
    }

    /**
     * This method is used to update trainer Details
     *
     */
    @override
    public String updateTrainerDetailsById(int trainerId, Trainer updatedTrainerDetails) {
        return trainerDao.modifyTrainerDetailsById(trainerId, updatedTrainerDetails);
    }

    /**
     * This method is used to update trainee Details
     *
     */
    @Override
    public String updateTraineeDetailsById(int traineeId, Trainee updatedTraineeDetails) {
        return traineeDao.modifyTraineeDetailsById(traineeId, updatedTraineeDetails);
    }

    /**
     * This method is used to remove trainer Details
     *
     */
    @Override
    public String deleteTrainerDetailsById(int trainerId) {
        return trainerDao.removeTrainerDetails(trainerId);
    }

    /**
     * This method is used to remove trainee Details
     *
     */ 
    @override   
    public String deleteTraineeDetailsById(int traineeId) {
        return traineeDao.removeTraineeDetails(traineeId);
    }

    /**
     * This method is used to update details of trainees assigned to trainer in trainer details
     *
     */           
    public String changeTrainerDetailsById(int trainerId, Trainer trainer) {
        return trainerDao.modifyTrainerDetailsById(trainerId, trainer);
    }

    /**
     * This method is used to update details of trainer assigned to trainee in trainee details
     *
     */           
    public String changeTraineeDetailsById(int traineeId, Trainee trainee) {
        return traineeDao.modifyTraineeDetailsById(traineeId, trainee);
    } 
} 
   
    

    

   