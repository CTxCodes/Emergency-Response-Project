/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencytest;

/**
 *
 * @author cjt1496
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Emergency {
    
    private static String fName;
    private static String lName;
    private static String address = "1234 sesame street";
    private static String phoneNumber = "123-456-7891";
    private static String natureOfEmergency;
    private static String filePoliceReport;
    
    private final String police = "police";
    private final String ambulance = "ambulance";
    private final String fireDepartment = "Fire Department";
    
    
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        Emergency.fName = fName;
    }
    
    public String getlName(){
        return lName;
    }
    
    public void setlName(String lName){
        Emergency.lName = lName;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address){
        Emergency.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
       
        Emergency.phoneNumber = phoneNumber;
    }

    public String getNatureOfEmergency() {
        return natureOfEmergency;
    }

    public void setNatureOfEmergency(String natureOfEmergency) {
        Emergency.natureOfEmergency = natureOfEmergency;
    }

    public String getPolice() {
        return police;
    }

    public String getAmbulance() {
        return ambulance;
    }

    public String getFireDepartment() {
        return fireDepartment;
    }
    
    
    // Start of Constructors
    public void Emergency(){
        
    }
    
    public void Emergency(String fName, String lName, String address, String phoneNumber, 
            String natureOfEmergency){
        Emergency.fName = fName;
        Emergency.lName = lName;
        Emergency.phoneNumber = phoneNumber;
        Emergency.natureOfEmergency = natureOfEmergency;
    
    }
    
    public void Emergency(String fName, String lName, String phoneNumber, String address){
        Emergency.lName = lName;
        Emergency.fName = fName;  
        Emergency.phoneNumber = phoneNumber;
        Emergency.address = address;
       
    }
    
    public void Emergency(String natureOfEmergency){
        Emergency.natureOfEmergency = natureOfEmergency;
           }
    // End of Constructors
    
    public void Nine_One_One(){
        Scanner input = new Scanner(System.in);
        System.out.println("You just called 9-1-1. What is your first name?");
        fName = input.next();
        System.out.println("What is your last name?");
        lName = input.next();
        
        do{
        System.out.println("Hello " + fName + " What is the nature of your emergency? (TYPE IN YOUR EMERGENCY) \n"
                + "1. Violent\n"
                + "2. Injury\n"
                + "3. Robbery\n"
                + "4. Missing Person");
        natureOfEmergency = input.next();
        
        }while(!"Violent".equals(natureOfEmergency) &&
                !"Injury".equals(natureOfEmergency) && 
                !"Robbery".equals(natureOfEmergency) &&
                !"Missing Person".equals(natureOfEmergency)
                );
        
         switch (natureOfEmergency) {
                case "Violent":
                    determine_Emergency_Response(natureOfEmergency);
                    break;
                case "Injury":
                    determine_Emergency_Response(natureOfEmergency);
                    break;
                case "Robbery":
                    determine_Emergency_Response(natureOfEmergency);
                    break;
                case "Missing Person":
                    determine_Emergency_Response(natureOfEmergency);
                    break;
                default:
                    System.out.println("You must type word for word, case sensative, the type of emergency you are experiencing.");
                    break;
            }    
        }
    
    private void determine_Emergency_Response(String natureOfEmergency){
        
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
      
        System.out.println("\nPolice department has recieved your emergency!");
        System.out.println("heading towards " + address);
        System.out.println("Call recieved from " + phoneNumber );
        System.out.println(dtf.format(now));  
        
        switch (natureOfEmergency) {
                case "Violent":          
                    System.out.println("The " + police + " and the " + ambulance + " are heading your way!");              
                    break;
                case "Injury":                 
                    System.out.println("An " + ambulance + " and the " + fireDepartment + " are heading your way!");
                    break;
                case "Robbery":         
                    System.out.println("The " + police + " are heading your way!");
                    break;
                case "Missing Person":     
                    System.out.println("The " + police + "Are heading your way!");
                    break;
                default:
                    break;
                }
        
                System.out.println("\nDo you want to file another police report? If yes press \"y\" if no press \"n\"");
                filePoliceReport = input.next();
                if("y".equals(filePoliceReport)){
                    Nine_One_One();
                } else if ("n".equals(filePoliceReport)){
                    input.close();
            }         
        }
    }
