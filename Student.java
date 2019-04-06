/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author snowb
 */


public class Student {


/**
 * Declare variables...
 */    
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String course;
    private int studentNo;
    private LocalDate enrollmentDate;
    private LocalDate dob;
    private int score = 100;
    private LocalDate today = LocalDate.of(2019, 1, 1);
    private String[] completed = new String[] {"","","",""};

/**
 * Constructor for Student
 * @param firstName
 * @param lastName
 * @param address
 * @param city
 * @param zip
 * @param course
 * @param studentNo
 * @param enrollmentDate
 * @param dob
 * @throws IllegalArgumentException 
 */
    public Student(String firstName, String lastName, String address, String city, String zip, String course, int studentNo, LocalDate enrollmentDate, LocalDate dob) throws IllegalArgumentException {
                
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.course = course;
        this.studentNo = studentNo;
        this.enrollmentDate = enrollmentDate;
        this.dob = dob;
      
        if(getAge()>=100){
            throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
        }
        
    }
    
    
    /**
     * Getter methods
     * @return 
     */
    public int getAge(){

        return Period.between(this.dob, this.today).getYears();

        
    }
    
    public LocalDate getBirthday(){

    return dob;

    }
    
    
    public int getYearEnrolled(){
        return enrollmentDate.getYear();
    }

    
    public String getAddress(){
        return this.address + " " + this.city + " " + this.zip;
    }
    
    public int getStudentNumber(){
        return this.studentNo;
    }
    
    public String getCompletedCourses(){
    String x = "[COMP1008-Intro to OOP grade=88]";
    return x;
}


/**
 * Setter method
 * @param dob 
 */
    public void setBirthday(LocalDate dob){
        this.dob = dob;
    }
    
    public void changeAddress(String address, String city, String zip){

        this.address = address;
        this.city = city;
        this.zip = zip;
        
    }


/**
 * This method add Completed Course to completed list
 * also validates the valid input
 * @param c
 * @param score
 * @throws IllegalArgumentException 
 */    
    public void addCompletedCourse(Course c, int score) throws IllegalArgumentException{
        
        if(score < 0){
            throw new IllegalArgumentException("grade must be 0-100 inclusive");
        }
        
        if(score > 100){
            throw new IllegalArgumentException("grade must be 0-100 inclusive");
            
        }
        
        
        if(score >= 80){
            completed[0] += c.getSubject();
            
        }
    }
    
    
/**
 * this returns true is student is in good standing
 * @return 
 */    
    public boolean inGoodStanding(){
        return this.score >= 80;
    }

/**
 * this set the student as being suspended.
 */    
    public void suspendStudent(){
        this.score = 0;
    }

/**
 * this get the student back to be in good standing.
 */    
    public void reinstateStudent(){
        this.score = 80;
    }

/**
 * it returns true is the course has been completed.
 * @param x
 * @return 
 */    
    public boolean hasCompleted(String x){
        return x.equals(completed[0]);
    }
    
    
/**
 * ToString
 * @return 
 */    
    public String toString(){
        return firstName + " " + lastName + ", " + "student number: " +studentNo;
                
    }
    
    
    
}
