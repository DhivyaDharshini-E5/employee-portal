package com.element5.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.Period;

import com.element5.model.Trainer;
import com.element5.model.Trainee;

public interface EmployeeService {

    /**
     * This method is used to add informations about a trainer in trainer list
     *
     * @param employeeId, trainee parameters are passed to insert the trainer details in the list
     *
     */
    public void addTrainer(int id, String employeeId, String name,long mobileNumber, String email, String designation,
                           String dateOfBirth, String projectName, String dateOfJoining, int experience);

    
     public String generatedId();
}

