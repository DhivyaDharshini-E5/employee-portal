package com.element5.dao;

import com.element5.model.Trainee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;

import java.util.Iterator;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.element5.util.Factory;

public class TraineeDaoImpl implements TraineeDao {

    static private Logger logger = LoggerFactory.getLogger(TraineeDaoImpl.class);
    
    public String insertIntoTrainee(Trainee trainee) {

        Transaction tx = null;
        String error = "Trainee details not sucessfully added";
        
        try (Session session = Factory.getFactory().openSession();) {
  
            tx = session.beginTransaction();
            session.save(trainee);     
            tx.commit();
            logger.info("Trainee details are successfully added");
         } catch(HibernateException e) {
              if (tx!=null) {
                  tx.rollback();
              }
              e.getMessage();
         }
         return error;
    }
 
    public Trainee showTraineeDetailsById(int traineeId) {

        Transaction tx = null;
        Trainee trainee = null;
        try(Session session = Factory.getFactory().openSession();) {
            tx = session.beginTransaction();
            Trainee traineeDetails = (Trainee) session.get(Trainee.class, traineeId);
            trainee = traineeDetails;
            tx.commit();
        } catch(HibernateException e) {

            if(tx!=null) {

                tx.rollback();
            }
            e.printStackTrace();
        }
        return trainee;
    }

    public List<Trainee> showAllTraineeDetails() {
    
        Transaction tx = null;
        List<Trainee> traineesInformations = new ArrayList<>();
        try (Session session = Factory.getFactory().openSession();) {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Trainee.class);
            criteria.add(Restrictions.eq("isDeleted", false));
            List<Trainee> results = criteria.list();
            traineesInformations = results;
         } catch (HibernateException e) {

            if(tx!=null) {

                tx.rollback();
            }
            e.getMessage();
        }
        return traineesInformations;
    }

    public String modifyTraineeDetailsById(int traineeId, Trainee updatedTraineeDetails) {
        Transaction tx = null;
        String error = "Trainee details are not successfully updated";
        try(Session session = Factory.getFactory().openSession();) {
           tx = session.beginTransaction(); 
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
           tx.commit();
           logger.info("Trainee details are successfully updated");
        } catch(HibernateException e) {  

            if(tx!=null) {
                tx.rollback();
            }
            e.getMessage();
        }
        return error;
    } 
 
    public String removeTraineeDetails(int traineeid) {

        Transaction tx = null;
        String message = "Trainee Details not deleted";
        try (Session session = Factory.getFactory().openSession();) {

            tx = session.beginTransaction();
            Trainee trainee = (Trainee) session.get(Trainee.class, traineeid);
            trainee.setIsDeleted(true);
            session.update(trainee);
            message = "trainee details deleted successfully";
            tx.commit();
        } catch (HibernateException e) {

            if(tx != null) {
                tx.rollback();
            }
            e.getMessage();
        }
        return message;
    }           
           
}  
     