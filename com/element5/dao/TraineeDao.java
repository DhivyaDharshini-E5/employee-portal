package com.element5.dao;

import com.element5.model.Trainee;
import com.element5.util.Factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * <h3>TrainerDao</h3>
 * This interface holds the abstract methods of TraineeDaoImplementation class and it has finally implemented in TraineeDaoImplementation class
 *
 * @author Dhiyva
 * @version 1.1
 * @since 2022
 *
 */
public interface TraineeDao {

    /**
     *<p> This method is used to insert trainee details in trainee table <\p>
     *
     * @param Trainee details is passed as a parameter
     *
     * @return String
     *
     */    
    public String insertIntoTraineeTable(Trainee trainee);

    /**
     * This method is used to display trainee details
     *
     * @param TrainerId is passed as a parameter
     *
     * @return Trainee details
     *
     */    
    public Trainee showTraineeDetailsById(int traineeId);

    /**
     * This method is used to display all trainee details
     *
     * @return Trainees informations
     *
     */    
    public List<Trainee> showAllTraineeDetails();

    /** 
     * This method is used to update trainee details
     *
     * @return updated trainee details
     *
     */    
    public String modifyTraineeDetailsById(int traineeId, Trainee updatedTraineeDetails);

    /** 
     * This method is used to remove a trainee details
     *
     * @return String
     *
     */    
    public String removeTraineeDetails(int trainerid);
}