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

import com.element5.util.Factory;

public interface TraineeDao {

    public String insertIntoTrainee(Trainee trainee);

    public Trainee showTraineeDetailsById(int traineeId);

    public List<Trainee> showAllTraineeDetails();

    public String modifyTraineeDetailsById(int traineeId, Trainee updatedTraineeDetails);

    public String removeTraineeDetails(int trainerid);
}