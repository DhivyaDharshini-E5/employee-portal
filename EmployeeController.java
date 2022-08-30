import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap; 
import java.util.List;
import java.util.ArrayList;

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

        while(inputs!=9) {

            logger.info("HI!!CHOOSE AN OPTION FROM THE FOLLOWING:\n1. Add an Trainer Details\n2. Add an Trainee Details\n3. View an Employee Details\n4. Show all Employee Details\n5. Update an Employee Details\n6. Remove an Employee details\n7. Assign trainer to trainee\n8. Assign trainees to trainer\n9. Stop");
            inputs = scanner.nextInt();
            scanner.nextLine();

            switch(inputs) { 

            case 1 :

                setTrainerDetails();
                break;
              
            case 2 :

                setTraineeDetails();
                break;

            case 3:
             
                System.out.println("1. Trainer Details\n2. Trainee Details\n3. Exit");
                int choice = scanner.nextInt();

                switch(choice) {
      
                case 1 :

                     logger.info("Enter the Trainer Id:");
                     int trainerId = scanner.nextInt();
                     System.out.println("The Trainer Details:" +"\n"+ service.viewTrainerDetailsById(trainerId));                                          
                     break;

                case 2 :

                     logger.info("Enter the Trainee Id:");
                     int traineeId = scanner.nextInt();
                     System.out.println("The Trainee Details:" +"\n"+ service.viewTraineeDetailsById(traineeId)); 
                     Trainer trainer = service.viewTraineeDetailsById(traineeId).getTrainerDetails();
                                      System.out.println("Trainer Name: " + trainer.getName());
                                      System.out.println("Trainer Id:" + trainer.getId());
                                      System.out.println("Trainer Email:" + trainer.getEmail());
                     
                     break;

                case 3 :

                     logger.info("you exited the portal");
                     break;

                 }             
                 break;

             case 4:
             
                System.out.println("1. Trainer Details\n2. Trainee Details\n 3.Exit");
                choice = scanner.nextInt();

                    switch(choice) {
      
                    case 1 :

                        logger.info("The Trainers Details:" +"\n"+ service.viewAllTrainerDetails()); 
                        break;

                    case 2 :

                        logger.info("The Trainee Details:" + service.viewAllTraineeDetails());
                        break;

                    case 3 :

                        logger.info("you exited the portal");
                        break;                  

                    }
                    break;

            case 5 :

                 System.out.println("whom you want to update:\n1. Trainer Details\n2. Trainee Details\n3. Exit");
                 choice = scanner.nextInt();

                 switch(choice) {
             
                 case 1 :
    
                     System.out.println("Enter the ID of an Employee You want to update:");
                     int trainerId = scanner.nextInt();
                     Trainer trainerDetails = service.viewTrainerDetailsById(trainerId);
                     Trainer updatedTrainerDetails  = updateTrainerDetails(trainerDetails);
                     service.updateTrainerDetailsById(trainerId, updatedTrainerDetails);
                     break;

                 case 2 :
     
                     System.out.println("Enter the ID of an Employee You want to update :");
                     int traineeId = scanner.nextInt();
                     Trainee traineeDetails = service.viewTraineeDetailsById(traineeId);
                     Trainee updatedTraineeDetails = updateTraineeDetails(traineeDetails);
                     service.updateTraineeDetailsById(traineeId, updatedTraineeDetails);
                     logger.info("Trainee details are successfully updated");
                     break; 

                 case 3 :

                     logger.info("you exited the portal");
                     break;

                 }
                 break;
               
            case 6 :
             
                System.out.println("1. Trainer Details\n2. Trainee Details\n3. Exit");
                choice = scanner.nextInt();

                switch(choice) {
      
                case 1 :

                     logger.info("Enter the Trainer Id:");
                     int trainerId = scanner.nextInt();
                     service.deleteTrainerDetailsById(trainerId); 
                     break;

                case 2 :

                     logger.info("Enter the Trainee Id:");
                     int traineeId = scanner.nextInt();
                     service.deleteTraineeDetailsById(traineeId);
                     break;

                case 3 :

                     logger.info("you exited the portal");
                     break;

                }
                break;
 
             case 7 :
                  
                  logger.info("Enter the TraineeId you want to assign trainer");
                  int traineeId = scanner.nextInt();
                  assignTrainerToTrainee(traineeId);
                  break;

             case 8 :
                  
                  logger.info("Enter the TrainerId you want to assign trainees");
                  int trainerId = scanner.nextInt();
                  assignTrainerToTrainee(trainerId);
                  break;                                  
                     
             case 9 :
                  
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

          int id = 0;

          logger.info("Enter the Email Address");
          String email = validEmail();
           
          logger.info("Enter the Designation:");
          String designation = scanner.nextLine();
                     
          logger.info("Enter the Contact Number:");
          String contactNumber = validContact();
          long mobileNumber = Long.parseLong(contactNumber);
  
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
                
          service.addTrainer(id, name, mobileNumber, email, designation,
                             dateOfBirth, projectName, dateOfJoining, experience);
                           
          System.out.println("*****************************************************");
          logger.info("Trainer Details are successfully added");
          System.out.println("*******************************************************");
              
     } 

     public static void setTraineeDetails() {

         logger.info("Enter the EmployeeName:");
         String name = validName();

         int id = 0;

         logger.info("Enter the Email Address");
         String email = validEmail();
           
         logger.info("Enter the Designation:");
         String designation = scanner.nextLine();
                     
         logger.info("Enter the Contact Number:");
         String contactNumber = validContact();
         long mobileNumber = Long.parseLong(contactNumber);
  
         logger.info("Enter Your Date Of Birth in yyyy-mm-dd format:");
         String dateOfBirth = scanner.nextLine();
         int age = service.calculateAge(dateOfBirth);
         logger.info("Trainer's age:"+ service.calculateAge(dateOfBirth));
           
         logger.info("Enter the pass out year:");
         String passOutYear = scanner.nextLine();

         logger.info("Enter the Task Name:"); 
         String taskName = scanner.nextLine();

         logger.info("Enter your college name:");
         String collegeName = scanner.nextLine();
         
                
         service.addTrainee(id, name, mobileNumber, email, designation,
                             dateOfBirth, taskName, passOutYear, collegeName);
                           
         System.out.println("*****************************************************");
         logger.info("Trainee Details are successfully added");
         System.out.println("*******************************************************");
    }
              
      
    /**
     * This method is used to get informations from the user and update informations about trainer
     *
     * @return updated trainer details 
     */
     public static Trainer updateTrainerDetails(Trainer trainerDetails) {

          logger.info("Enter the value you want to update otherwise press enter to skip"); 
          scanner.nextLine();        
          logger.info("Enter the update Name:");
          String name = scanner.nextLine();
          if(!name.isEmpty()) {
              trainerDetails.setName(name);
          }
          logger.info("Enter the update Designation:");
          String designation = scanner.nextLine();
          if(!designation.isEmpty()) {
              trainerDetails.setDesignation(designation);
          }
          logger.info("Enter the update ContactNumber:");
          String contactNumber = scanner.nextLine();
          if(!contactNumber.isEmpty()) {
              long mobileNumber = Long.parseLong(contactNumber); 
              trainerDetails.setMobileNumber(mobileNumber);
          }
          logger.info("Enter the update Experience:");
          String experience = scanner.nextLine();
          if(!experience.isEmpty()) {
              int updatedExperience = Integer.valueOf(experience);
              trainerDetails.setExperience(updatedExperience);
          }
          logger.info("Enter the update Project Name:");
          String projectName = scanner.nextLine();
          if(!projectName.isEmpty()) {
              trainerDetails.setProjectName(projectName);
          }
          logger.info("Enter the update DateOfBirth:");
          String dateOfBirth = scanner.nextLine();
          if(!dateOfBirth.isEmpty()) {
              trainerDetails.setBirthDate(dateOfBirth);
          }
          logger.info("Enter the update DateOfJoining:");
          String dateOfJoining = scanner.nextLine();
          if(!dateOfJoining.isEmpty()) {
              trainerDetails.setJoiningDate(dateOfJoining);
          }
          logger.info("Enter the update Email");
          String email = scanner.nextLine();
          if(!email.isEmpty()) {
              trainerDetails.setEmail(email);
          }
          return trainerDetails;
     } 

    /**
     * This method is used to get informations from the user and update informations about trainee
     *
     * @return updated trainee details 
     */
     public static Trainee updateTraineeDetails(Trainee traineeDetails) {

          logger.info("Enter the value you want to update otherwise press enter to skip"); 
          scanner.nextLine();        
          logger.info("Enter the update Name:");
          String name = scanner.nextLine();
          if(!name.isEmpty()) {
              traineeDetails.setName(name);
          }
          logger.info("Enter the update Designation:");
          String designation = scanner.nextLine();
          if(!designation.isEmpty()) {
              traineeDetails.setDesignation(designation);
          }
          logger.info("Enter the update ContactNumber:");
          String contactNumber = scanner.nextLine();
          if(!contactNumber.isEmpty()) {
              long mobileNumber = Long.parseLong(contactNumber); 
              traineeDetails.setMobileNumber(mobileNumber);
          }
          logger.info("Enter the update Task Name:");
          String taskName = scanner.nextLine();
          if(!taskName.isEmpty()) {
              traineeDetails.setTaskName(taskName);
          }
          logger.info("Enter the update DateOfBirth:");
          String dateOfBirth = scanner.nextLine();
          if(!dateOfBirth.isEmpty()) {
              traineeDetails.setBirthDate(dateOfBirth);
          }
          logger.info("Enter the update PassOutYear:");
          String passOutYear = scanner.nextLine();
          if(!passOutYear.isEmpty()) {
              traineeDetails.setPassOutYear(passOutYear);
          }
          logger.info("Enter the update Email");
          String email = scanner.nextLine();
          if(!email.isEmpty()) {
              traineeDetails.setEmail(email);
          }
          logger.info("Enter the update College Name:");
          String collegeName = scanner.nextLine();
          if(!collegeName.isEmpty()) {
            traineeDetails.setCollegeName(collegeName);
          } 
          return traineeDetails;
     }

     public static void assignTrainerToTrainee(int traineeId) {

         Trainee trainee= service.viewTraineeDetailsById(traineeId);
         if (trainee!=null) {
            logger.info("Enter the TrainerId you want to assign to this Trainee:");
            int trainerId = scanner.nextInt();
            Trainer trainer = service.viewTrainerDetailsById(trainerId);
            if(trainer!=null) {
                trainee.setTrainerDetails(trainer);
                service.changeTraineeDetailsById(traineeId, trainee);
            } else {
                logger.error("No trainer details found");
            }
         } else {
              logger.error("No trainee details found");
         }
      }

 
      public static void assignTraineesToTrainer(int trainerId) {

          Trainer trainer = service.viewTrainerDetailsById(trainerId);
          if (trainer!=null) {
              logger.info("how many trainees you want to add");
                     List<Trainee> traineeDetails = new ArrayList<>();
              int noOfTrainees = scanner.nextInt();
              while(noOfTrainees > 0) {
                  logger.info("Enter the TraineeId you want to assign to this Trainer:");
                  int traineeId = scanner.nextInt();
                  Trainee trainee = service.viewTraineeDetailsById(traineeId);
                  if(trainee!=null) {
                     traineeDetails.add(trainee);
                     trainer.setTraineeDetails(traineeDetails);
                     service.changeTrainerDetailsById(trainerId, trainer);
                     noOfTrainees--;
                  } else {
                     logger.error("No trainee Details found");
                     noOfTrainees--;
                  }
               }
           } else {
               logger.error("No trainer details found");
           }
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
          String contactNumber = null;
          while(isValidContact) {
              contactNumber = scanner.nextLine();
              boolean isValidFormat = EmployeeUtils.isValidateNumber(contactNumber);
              if(isValidFormat) {
                  isValidContact = false;
              } else {
                  isValidContact = true;
                  logger.error("Contact Number should only contain numbers from 0-9:");
                  System.out.println("Please enter valid input");
              }
          }
          
          return contactNumber;
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
          

  
             
             
       
  