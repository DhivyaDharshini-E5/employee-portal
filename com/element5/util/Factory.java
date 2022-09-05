package com.element5.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.element5.model.Trainer;
import com.element5.model.Trainee;

public class Factory {

    private static SessionFactory factory = null;
    private static Logger logger = LoggerFactory.getLogger(Factory.class);

    public static SessionFactory getFactory() {

        try {
            factory = new Configuration().
                      configure().
                      addAnnotatedClass(Trainer.class).
                      addAnnotatedClass(Trainee.class).buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }  
        return factory;
    }
}