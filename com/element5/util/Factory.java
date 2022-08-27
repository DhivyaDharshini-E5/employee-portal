package com.element5.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.element5.model.Trainer;
import com.element5.model.Trainee;

public class Factory {

    private static SessionFactory factory;
    private static Logger logger = LoggerFactory.getLogger(Factory.class);

    public static SessionFactory getFactory() {

        try {
           factory = new Configuration().
                     configure().
                     addPackage("com.element5.model").
                     addAnnotatedClass(Trainer.class).
                     addAnnotatedClass(Trainee.class).
                     buildSessionFactory();
        } catch (Throwable e) {
              logger.error("Failed to create sessionFactory object." + e);
              throw new ExceptionInInitializerError(e);
        }
  
        return factory;
    }
}