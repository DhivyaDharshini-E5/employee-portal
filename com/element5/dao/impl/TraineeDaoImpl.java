package com.element5.dao.impl;

import com.element5.dao.TraineeDao;
import com.element5.model.Trainee;
import com.element5.util.Factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * <h3>TrainerDaoImpl</h3>
 * <p>This class holds the implementations of Interface TrainerDao class<\p>
 *
 */
public class TraineeDaoImpl implements TraineeDao {

    private Logger logger = LoggerFactory.getLogger(TraineeDaoImpl.class);

    /**
     *<p>This method is used to insert trainee details in trainee table</p>
     *
     * @param Trainee details is passed as a parameter
     *
     * @return String
     *
     */
    @Override    
    public String insertTrainee(Trainee trainee) {

        Transaction transaction = null;
        Session session = null;
        String error = "Trainee details not sucessfully added";   
 
        try {
            session = Factory.getFactory().openSession(); 
            transaction = session.beginTransaction();
            session.save(trainee);     
            transaction.commit();
            logger.info("Trainee details are successfully added");
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
     *<p>This method is used to display trainee details<\p>
     *
     * @param TraineeId is passed as a parameter
     *
     * @return Trainee details
     *
     */    
    @Override        
    public Trainee showTraineeDetailsById(int traineeId) {

        Trainee trainee = null;
        Session session = null;

        try {
            session = Factory.getFactory().openSession();
            Trainee traineeDetails = (Trainee) session.get(Trainee.class, traineeId);
            trainee = traineeDetails;
        } catch(HibernateException e) {
            logger.error("{}", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return trainee;
    }

    /**
     *<p>This method is used to display all trainee details<\p>
     *
     * @return Trainees informations in a list
     *
     */ 
    @Override       
    public List<Trainee> showAllTraineeDetails() {  

        List<Trainee> traineesInformations = new ArrayList<>();
        Session session = null;

        try {
            session = Factory.getFactory().openSession(); 
            Criteria criteria = session.createCriteria(Trainee.class);
            criteria.add(Restrictions.eq("isDeleted", false));
            List<Trainee> results = criteria.list();
            traineesInformations = results;
        } catch (HibernateException e) {
            logger.error("{}", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return traineesInformations;
    }

    /** 
     *This method is used to update trainee details
     *
     * @return updated trainee details
     *
     */ 
    @Override       
    public String modifyTraineeDetailsById(int traineeId, Trainee updatedTraineeDetails) {

        Transaction transaction = null;
        Session session= null;
        String error = "Trainee details are not successfully updated";

        try {
           session = Factory.getFactory().openSession();
           transaction = session.beginTransaction(); 
           Trainee trainee = (Trainee)session.get(Trainee.class, traineeId);
           trainee.setName(updatedTraineeDetails.getName());
           trainee.setMobileNumber(updatedTraineeDetails.getMobileNumber());
           trainee.setEmail(updatedTraineeDetails.getEmail());
           trainee.setDesignation(updatedTraineeDetails.getDesignation());
           trainee.setBirthDate(updatedTraineeDetails.getBirthDate());
           trainee.setTaskName(updatedTraineeDetails.getTaskName());
           trainee.setPassOutYear(updatedTraineeDetails.getPassOutYear());
           trainee.setCollegeName(updatedTraineeDetails.getCollegeName());
           trainee.setTrainerDetails(updatedTraineeDetails.getTrainerDetails());
           session.update(trainee);
           transaction.commit();
           logger.info("Trainee details are successfully updated");
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
     *This method is used to remove a trainee details
     *
     * @return String
     *
     */
    @Override        
    public String removeTraineeDetails(int traineeid) {

        Transaction transaction = null;
        Session session = null;
        String message = "Trainee Details not deleted";

        try {
            session = Factory.getFactory().openSession();
            transaction = session.beginTransaction();
            Trainee trainee = (Trainee) session.get(Trainee.class, traineeid);
            trainee.setIsDeleted(true);
            session.update(trainee);
            message = "trainee details deleted successfully";
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
     