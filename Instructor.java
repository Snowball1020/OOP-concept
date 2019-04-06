/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

/**
 *
 * @author snowb
 */
public class Instructor {
    
/**
 * Declare instance variables...
 */    
private String firstName;
private String lastName;
private int empid;
private String address;
private String city;
private String zip;
private LocalDate hiringDate;
private LocalDate dob;
private LocalDate today = LocalDate.of(2019, 1, 1);
private String subjects[] = new String[] {"","","",""};
private int count = 0;

/**
 * Constructor forInstructor
 * @param fn
 * @param ln
 * @param empid
 * @param address
 * @param city
 * @param zip
 * @param hiringDate
 * @param dob
 * @throws IllegalArgumentException 
 */
    public Instructor(String fn, String ln, int empid, String address, String city, String zip, LocalDate hiringDate, LocalDate dob) throws IllegalArgumentException{
        
        this.firstName = fn;
        this.lastName = ln;
        this.empid = empid;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.hiringDate = hiringDate;
        this.dob = dob;
        
        if(getAgeInYears() >= 100){
            throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
        }
        
        if(yearsAtCollege() >= 80){
            throw new IllegalArgumentException("The hired on date for Anita Knapp is more than 80 years ago, it has been set to null.");
            
        }
       
    }
    
    /**
     * Getter methods 
     * @return 
     */
    
        public String getName(){
            return this.firstName;
        }
    
    
        public int getAgeInYears(){

        return Period.between(this.dob, this.today).getYears();

        }

        public int yearsAtCollege(){

        return Period.between(this.hiringDate,this.today).getYears();
        
       }
        
        public String getAddress(){
            return this.address + ", " + this.city + ", " + this.zip;
        }

        
/**
 * Setter methods
 * @param address
 * @param city
 * @param zip 
 */        
        public void changeAddress(String address, String city, String zip){
            this.address = address;
            this.city = city;
            this.zip = zip;
                 
        }
        
        public void setBirthday(LocalDate date) throws IllegalArgumentException{
            if(Period.between(date, today).getYears()>=100){
                throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old.");

            }else{
                System.out.println("SET!");
                this.dob = date;
            }
        }

    
/**
 * This method returns 'Subject certified to teach' as String type
 * @return 
 */     
        public String listOfSubjectsCertifiedToTeach(){
            
            if(this.subjects[0].equals("")){
                this.subjects[0] = "not qualified to teach courses yet.";
                return subjects[0];
            }else if(!this.subjects[0].equalsIgnoreCase("") && !this.subjects[1].equalsIgnoreCase("")){
                return "["+this.subjects[0] +", " + this.subjects[1] + "]";
            }
            
            else{
                return Arrays.toString(subjects);                
            }
            
        }
        
/**
 * This methods add Course to subjects list
 * @param subject 
 */        
        public void addCourseToAbilities(String subject){
        
            if(subjects[0].equalsIgnoreCase(subject) || subjects[1].equalsIgnoreCase(subject)){
                
            }else{
                this.subjects[count] = subject;
                count++;                
            }
            
            
        }
 

/**
 * This method returns True is the subject matches with what is in subjects list
 * @param subject
 * @return 
 */        
        public boolean canTeach(String subject){
            
            if(subject.equalsIgnoreCase(subjects[0]) || subject.equalsIgnoreCase(subjects[1]))
                return true;
            else{
                return false;            
            }
        }
        
        
/**
 * ToString
 * @return 
 */
        
        
  public String toString(){
  
      return firstName + " " + lastName;
      
      }      
        
}
