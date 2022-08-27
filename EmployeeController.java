import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap; 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.element5.model.Trainer;
import com.element5.model.Trainee;
import com.element5.service.EmployeeServiceImpl;
import com.element5.util.EmployeeUtils;
import com.element5.exception.InvalidException;

/**
 * <h3>EmployeeController<h3>
 * This class is used to get inputs from the user and stored them in the database of trainers and trainees and display the output to the user
 *
 * @author Dhivya
 * @version 3.1
 * @since 2022
 *
 */

public class EmployeeController {

    static Scanner scanner = new Scanner(System.in); 
    static private EmployeeServiceImpl service = new EmployeeServiceImpl();
    static private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
  
    public static void main(String[] args) {  

        String role;
        int inputs = 0;

        while(inputs!=11) {

            logger.info("HI!!CHOOSE AN OPTION FROM THE FOLLOWING:\n1. Add an Trainer Details\n2. Add an Trainee Details\n3. View an Employee Details\n4. Show all Trainer Details\n5. Show all Trainee Details\n6. Update an Employee Details\n7. Remove an Employee details\n8. To assign trainers to trainees\n9. Get trainer-trainee Details\n10. Get trainee-trainer details\n11. Stop");
            inputs = scanner.nextInt();
            scanner.nextLine();

            switch(inputs) { 

            case 1 :

                setTrainerDetails();
                break;
              
            case 2 :

                setTraineeDetails();
                break;
 
            case 10 :

                  logger.info("Enter the traineeId:");
                  String traineeId = scanner.nextLine();
                  System.out.println(service.traineeAssociationById(traineeId));           
                  break;
                 
             case 11 :
                  
                  logger.info("You Exited the portal");
                  break;             
             }
        } 
   }
  
     /**
      * This method is used to set details about the trainer
      *
      */
      public static void setTrainerDetails() {

          logger.info("Enter the EmployeeName:");
          String name = validName();

          String employeeId = service.generatedId();
          logger.info("Your generated EmployeeId is:"+employeeId);

          logger.info("Enter the Email Address");
          String email = validEmail();
           
          logger.info("Enter the Designation:");
          String designation = scanner.nextLine();
                     
          logger.info("Enter the Contact Number:");
          String mobileNumber = validContact();
  
          logger.info("Enter Your Date Of Birth in yyyy-mm-dd format:");
          String dateOfBirth = scanner.nextLine();
          int age = service.calculateAge(dateOfBirth);
          logger.info("Trainer's age:"+ service.calculateAge(dateOfBirth));

          boolean isValidateExperience = false; 
          int experience = 0;
          while(!isValidateExperience) {

              try {

                  logger.info("Enter the Experience:");
                  experience = scanner.nextInt();
                  age = service.calculateAge(dateOfBirth);
                  if(EmployeeUtils.isValidateExperience(age, experience)) {
                      isValidateExperience = true;
                      logger.info("Experience is sucessfully added");
                  }
              } catch (InvalidException e) { 
                    logger.error(e.getMessage());
              }
          }
           
          scanner.nextLine();
          logger.info("Enter the Date Of Joining in dd-mm-yyyy format:");
          String dateOfJoining = validDate();

          logger.info("Enter the Project Name:"); 
          String projectName = scanner.nextLine();
                
          service.addTrainer(id, employeeId, name, mobileNumber, email, designation, experience,
                             projectName, dateOfJoining);
                           
          System.out.println("*****************************************************");
          logger.info("Trainer Details are successfully added");
          System.out.println("*******************************************************");
              
     }

      
     public static String validName() { 
         boolean isValidName = true;
         String name = null;
         while(isValidName) {
             name = scanner.nextLine();
             boolean isValidFormat = EmployeeUtils.isValidateName(name);
             if(isValidFormat) {
                 isValidName = false;
             } else {
                 isValidName = true;
                 logger.info("Numbers, special characters are not allowed");
                 System.out.println("Please enter the name correctly");
             }
          }

          return name;
      }
 
      public static String validContact() { 
          boolean isValidContact = true;
          String mobileNumber = null;
          while(isValidContact) {
              mobileNumber = scanner.nextLine();
              boolean isValidFormat = EmployeeUtils.isValidateNumber(mobileNumber);
              if(isValidFormat) {
                  isValidContact = false;
              } else {
                  isValidContact = true;
                  logger.error("Contact Number should only contain numbers from 0-9:");
                  System.out.println("Please enter valid input");
              }
          }
          
          return mobileNumber;
      }
 
      public static String validDate() { 
          boolean isValidDate = true;
          String date = null;
          while(isValidDate) {
              date = scanner.nextLine();
              boolean isValidFormat = EmployeeUtils.isValidateDate(date); 
              if(isValidFormat) {
                  isValidDate = false;
              } else {
                  isValidDate = true;
                  System.out.println("Please enter date of joining in this dd-mm-yyyy format:");
              }
          }

          return date;
      }
    
      public static String validEmail() { 
          boolean isValidEmail = true;
          String email = null;
          while(isValidEmail) {
              email = scanner.nextLine();
              boolean isValidFormat = EmployeeUtils.isValidateEmail(email); 
              if(isValidFormat) {
                  isValidEmail = false;
              } else {
                  isValidEmail= true;
                  logger.error("Email Address should be in this format: eg:abc@def.com");
                  System.out.println("Please enter valid email");
              }
          }

          return email;
      }                     
} 
          

  
             
             
       
  