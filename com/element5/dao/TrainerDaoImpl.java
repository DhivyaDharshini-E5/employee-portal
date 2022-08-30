package com.element5.dao;

import com.element5.model.Trainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.element5.util.Factory;

public class TrainerDaoImpl implements TrainerDao {

    static private Logger logger = LoggerFactory.getLogger(TrainerDaoImpl.class);
    
    public String insertIntoTrainer(Trainer trainer) {

        Transaction tx = null;
        String error = "Trainer details not sucessfully added";
        
        try (Session session = Factory.getFactory().openSession();) {
  
            tx = session.beginTransaction();
            session.save(trainer);     
            tx.commit();
            logger.info("Trainer details are successfully added");
         } catch(HibernateException e) {
              if (tx!=null) {
                  tx.rollback();
              }
              e.getMessage();
         }
         return error;
    }
 
    public Trainer showTrainerDetailsById(int trainerId) {

        Transaction tx = null;
        Trainer trainer = null;
        try(Session session = Factory.getFactory().openSession();) {
            tx = session.beginTransaction();
            Trainer trainerDetails = (Trainer) session.get(Trainer.class, trainerId);
            trainer = trainerDetails;
            tx.commit();
        } catch(HibernateException e) {

            if(tx!=null) {

                tx.rollback();
            }
            e.getMessage();
        }
        return trainer;
    }

    public List<Trainer> showAllTrainerDetails() {
    
        Transaction tx = null;
        List<Trainer> trainersInformations = new ArrayList<>();
        try(Session session = Factory.getFactory().openSession();) {
           tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Trainer.class);
            criteria.add(Restrictions.eq("isDeleted", false));
            List<Trainer> results = criteria.list();
            trainersInformations = results;
         } catch (HibernateException e) {

            if(tx!=null) {

                tx.rollback();
            }
            e.getMessage();
        }
        return trainersInformations;
    }

    public String modifyTrainerDetailsById(int trainerId, Trainer updatedTrainerDetails) {

        Transaction tx = null;
        String error = "Trainer details are not successfully updated";
        try(Session session = Factory.getFactory().openSession();) {
           tx = session.beginTransaction(); 
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
           tx.commit();
           logger.info("Trainer details are successfully updated");
        } catch(HibernateException e) {  

            if(tx!=null) {
                tx.rollback();
            }
            e.getMessage();
        }
        return error;
    } 

    public String removeTrainerDetails(int trainerid) {

        Transaction tx = null;
        String message = "Trainer Details not deleted";
        try (Session session = Factory.getFactory().openSession();) {

            tx = session.beginTransaction();
            Trainer trainer = (Trainer) session.get(Trainer.class, trainerid);
            trainer.setIsDeleted(true);
            session.update(trainer);
            message = "trainer details deleted successfully";
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
     
    
       
              

