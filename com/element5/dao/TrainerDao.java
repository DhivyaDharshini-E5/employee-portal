package com.element5.dao;

import com.element5.model.Trainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;

import java.util.Iterator;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.HibernateException;

import com.element5.util.Factory;

public interface TrainerDao {

    public String insertIntoTrainer(Trainer trainer);

    public Trainer showTrainerDetailsById(int trainerId);

    public List<Trainer> showAllTrainerDetails();

    public String modifyTrainerDetailsById(int trainerId, Trainer updatedTrainerDetails);

    public String removeTrainerDetails(int trainerid);
}