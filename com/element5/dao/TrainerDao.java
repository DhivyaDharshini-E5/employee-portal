package com.element5.dao;

import com.element5.model.Trainer;
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
 * This interface holds the abstract methods of TrainerDaoImplementation class and the methods are implemented in TrainerDaoImplementation class
 *
 * @author Dhiyva
 * @version 1.1
 * @since 2022
 *
 */

public interface TrainerDao {

    /**
     * <p>This method is used to insert trainee details in trainee table<\p>
     *
     * @param Trainee details is passed as a parameter
     *
     * @return String
     *
     */    
    public String insertIntoTrainerTable(Trainer trainer);

    /**
     * <p>This method is used to display trainer details<\p>
     *
     * @param TrainerId is passed as a parameter
     *
     * @return Trainer details
     *
     */    
    public Trainer showTrainerDetailsById(int trainerId);

    /** 
     * This method is used to display all trainer details
     *
     * @return Trainers informations in a list
     *
     */    
    public List<Trainer> showAllTrainerDetails();

    /**
     * This method is used to update trainer details
     *
     * @returnupdated trainer details
     *
     */    
    public String modifyTrainerDetailsById(int trainerId, Trainer updatedTrainerDetails);

    /**
     * This method is used to remove a trainer details
     *
     * @return String
     *
     */    
    public String removeTrainerDetails(int trainerid);
}