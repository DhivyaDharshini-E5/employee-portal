package com.element5.dao;

import com.element5.model.Trainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.HibernateException;

import com.element5.util.Factory;


public class TrainerDaoImpl {

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
 
   /* public Trainer viewTrainerDetailsById(int trainerId) {

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
    }*/
}  
     
    
       
              

