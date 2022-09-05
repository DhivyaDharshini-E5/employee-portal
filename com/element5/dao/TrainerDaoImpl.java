package com.element5.dao;

import com.element5.model.Trainer;
import com.element5.util.Factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * <h3>TrainerDaoImpl</h3>
 * This class holds the implementations of Interface TraineeDao class
 *
 */
public class TrainerDaoImpl implements TrainerDao {

    private Logger logger = LoggerFactory.getLogger(TrainerDaoImpl.class);
    
    /**
     * This method is used to insert trainee details in trainee table
     *
     * @param Trainee details is passed as a parameter
     *
     * @return String
     *
     */  
    @Override  
    public String insertIntoTrainerTable(Trainer trainer) {

        Transaction transaction = null;
        Session session = null;
        String error = "Trainer details not sucessfully added";        
        try {  
            Session session = Factory.getFactory().openSession();
            transaction = session.beginTransaction();
            session.save(trainer);     
            transaction.commit();
            logger.info("Trainer details are successfully added");
        } catch(HibernateException e) {
            transaction.rollback();
            logger.error("{}", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return error;
    }

    /** 
     * This method is used to display trainer details
     *
     * @param TrainerId is passed as a parameter
     *
     * @return Trainer details
     *
     */ 
    @Override   
    public Trainer showTrainerDetailsById(int trainerId) {

        Trainer trainer = null;
        Session session = null;
        try {
            Session session = Factory.getFactory().openSession();
            Trainer trainerDetails = (Trainer) session.get(Trainer.class, trainerId);
            trainer = trainerDetails;
        } catch(HibernateException e) {
            logger.error("{}", e);        
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return trainer;
    }

    /**
     * This method is used to display all trainer details
     *
     * @return Trainers informations in a list
     *
     */
    @Override    
    public List<Trainer> showAllTrainerDetails() {

        List<Trainer> trainersInformations = new ArrayList<>();
        Session session = null;
        try {
            Session session = Factory.getFactory().openSession(); 
            Criteria criteria = session.createCriteria(Trainer.class);
            criteria.add(Restrictions.eq("isDeleted", false));
            List<Trainer> results = criteria.list();
            trainersInformations = results;
        } catch (HibernateException e) {
            logger.error("{}", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return trainersInformations;
    }

    /**
     * This method is used to update trainer details
     *
     * @return updated trainer details
     *
     */  
    @Override  
    public String modifyTrainerDetailsById(int trainerId, Trainer updatedTrainerDetails) {

        Transaction transaction = null;
        Session session = null;
        String error = "Trainer details are not successfully updated";
        try {
           Session session = Factory.getFactory().openSession();
           transaction = session.beginTransaction(); 
           Trainer trainer = (Trainer)session.get(Trainer.class, trainerId);
           trainer.setName(updatedTrainerDetails.getName());
           trainer.setMobileNumber(updatedTrainerDetails.getMobileNumber());
           trainer.setEmail(updatedTrainerDetails.getEmail());
           trainer.setDesignation(updatedTrainerDetails.getDesignation());
           trainer.setBirthDate(updatedTrainerDetails.getBirthDate());
           trainer.setProjectName(updatedTrainerDetails.getProjectName());
           trainer.setJoiningDate(updatedTrainerDetails.getJoiningDate());
           trainer.setExperience(updatedTrainerDetails.getExperience());
           trainer.setTraineeDetails(updatedTrainerDetails.getTraineeDetails());
           session.update(trainer);
           transaction.commit();
           logger.info("Trainer details are successfully updated");
        } catch(HibernateException e) {  
            if(transaction!=null) {
                transaction.rollback();
            }
            logger.error("{}", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return error;
    } 

    /**
     * This method is used to remove a trainer details
     * 
     * @return String
     *
     */ 
    @Override   
    public String removeTrainerDetails(int trainerid) {

        Transaction transaction = null;
        Session session = null;
        String message = "Trainer Details not deleted";
        try {
            Session session = Factory.getFactory().openSession();
            transaction = session.beginTransaction();
            Trainer trainer = (Trainer) session.get(Trainer.class, trainerid);
            trainer.setIsDeleted(true);
            session.update(trainer);
            message = "trainer details deleted successfully";
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            logger.error("{}", e);       
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return message;
    }                          
}  
     
    
       
              

