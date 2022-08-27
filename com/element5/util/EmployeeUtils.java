package com.element5.util;

import com.element5.exception.InvalidException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.commons.validator.routines.EmailValidator;

public class EmployeeUtils { 

    public static boolean isValidateName(String name) {
    
         String expression ="^[a-zA-z ]*$"; 
         if (name.matches(expression)) {
                 return true;
         }
            
         return false;
    }

    public static boolean isValidateNumber(String number) {

         if(number.matches("^[0-9]{10}$")) {
             return true;
         }

         return false;
    }

    public static boolean isValidateGender(String gender) {
   
        if((gender.equalsIgnoreCase("male"))||(gender.equalsIgnoreCase("female"))||(gender.equalsIgnoreCase("Transgender"))) {
            return true;
        }

        return false; 
    }

    public static boolean isValidateAadhar(String aadharNumber) {

        if(aadharNumber.matches("^[0-9]{12}$")) {
            return true;
        }

        return false;
    }

    public static boolean isValidateBloodGroup(String bloodGroup) {

        if((bloodGroup.equalsIgnoreCase("O+"))||(bloodGroup.equalsIgnoreCase("A+"))||(bloodGroup.equalsIgnoreCase("B+"))||(bloodGroup.equalsIgnoreCase("AB+"))) {
            return true;
        }

        return false;
    }

    public static boolean isValidateDate(String dateOfJoining) {

        if(dateOfJoining.matches("(0[1-9]|[12][0-9]|[3][01])-(0[1-9]|1[012])-\\d{4}")) {
            return true;
        }

        return false;
    }

    public static boolean isValidateExperience(int age, int experience) throws InvalidException  {

        if ((age<23 && experience <= 2)||(age>23 && (experience <= 50 && experience <= (age - 23)))){
            return true;
        }
         
        throw new InvalidException("Experience is invalid for this age");
    }

    public static boolean isValidateEmail(String email) {
    
        boolean emailValidator = EmailValidator.getInstance().isValid(email);
        if (emailValidator) {
            return true;
        }
   
        return false;
     }      
}   



     
  
      
