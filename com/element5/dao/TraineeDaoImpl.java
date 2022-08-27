package com.element5.dao;

import com.element5.model.Trainee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.HibernateException;

import com.element5.util.Factory;

public class TraineeDaoImpl {

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
 
    /*public Trainee viewTrainerDetailsById(int traineeId) {

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
            e.getMessage();
        }
        return trainee;
    }*/
}
  