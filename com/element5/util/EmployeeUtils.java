package com.element5.util;

import com.element5.exception.InvalidException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * <h3> EmployeeUtils </h3>
 * This class has the methods for validation of inputs
 *
 */
public class EmployeeUtils { 

   /**
    *This method is used to validate name
    *
    * @param name of an employee is passed as an parameter
    *
    */
    public static boolean isValidateName(String name) {
    
         String expression ="^[a-zA-z ]*$"; 
         if (name.matches(expression)) {
                 return true;
         }
            
         return false;
    }

   /**
    *This method is used to validate number
    *
    * @param number of an employee is passed as an parameter
    *
    */
    public static boolean isValidateNumber(String number) {

         if(number.matches("^[0-9]{10}$")) {
             return true;
         }

         return false;
    }


   /**
    *This method is used to validate date
    *
    * @param joining date of an employee is passed as an parameter
    *
    */    
    public static boolean isValidateDate(String dateOfJoining) {

        if(dateOfJoining.matches("(0[1-9]|[12][0-9]|[3][01])-(0[1-9]|1[012])-\\d{4}")) {
            return true;
        }

        return false;
    }

   /**
    *This method is used to validate experience
    *
    * @param age, experience of an employee is passed as an parameter
    *
    */
    public static boolean isValidateExperience(int age, int experience) throws InvalidException  {

        if ((age<23 && experience <= 2)||(age>23 && (experience <= 50 && experience <= (age - 23)))){
            return true;
        }
         
        throw new InvalidException("Experience is invalid for this age");
    }

   /**
    *This method is used to validate Email
    *
    * @param email of an employee is passed as an parameter
    *
    */
    public static boolean isValidateEmail(String email) {
    
        boolean emailValidator = EmailValidator.getInstance().isValid(email);
        if (emailValidator) {
            return true;
        }
   
        return false;
     }      
}   



     
  
      
