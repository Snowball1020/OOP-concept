/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author snowb
 */
public class Course {

/**
 *  Declare instance variables... 
 */

    private String subject;
        private String presubject;
        private String courseName;
        private String room;
        private DayOfWeek dayOfWeek;
        private LocalTime localTime;
        private int size;
        private Instructor frank;
        private String classList[] = new String [10];
        private int count = 0;
        private int classSize = 0;
        private int age;
        private Student s;

        private LocalTime startTime = LocalTime.parse("08:00");
        private LocalTime lastTime = LocalTime.parse("18:00");

        
/**
 * Constructor for Course (without having 'prerequisite')
 * @param frank
 * @param subject
 * @param courseName
 * @param room
 * @param dayOfWeek
 * @param localTime
 * @param size
 * @throws IllegalArgumentException 
 */
public Course(Instructor frank, String subject, String courseName, String room, DayOfWeek dayOfWeek, LocalTime localTime, int size) throws IllegalArgumentException{
    
    if(localTime.isBefore(startTime)||localTime.isAfter(lastTime)){
        throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
    }
    
    if(subject.equalsIgnoreCase("COMP9999")){
        throw new IllegalArgumentException("Professor Frank Enstein is not qualified to teach COMP9999");
    }
    

    
    this.frank = frank;
    this.subject = subject;
    this.courseName = courseName;
    this.room = room;
    this.dayOfWeek = dayOfWeek;
    this.localTime = localTime;
    this.size = size;
    
    
    
}
/**
 * Constructor for Course (without having 'prerequisite')

 * @param frank
 * @param subject
 * @param courseName
 * @param room
 * @param dayOfWeek
 * @param localTime
 * @param size
 * @param presubject 
 */

    Course(Instructor frank, String subject, String courseName, String room, DayOfWeek dayOfWeek, LocalTime localTime, int size, String presubject) {
        this.frank = frank;
        this.subject = subject;
        this.courseName = courseName;
        this.room = room;
        this.dayOfWeek = dayOfWeek;
        this.localTime = localTime;
        this.size = size;
        this.presubject = presubject;
        

    }

/**
 * Getter methods
 * @return 
 */    
public String getSubject(){
    return this.subject;
}

public LocalTime getLocalTime(){
    return this.localTime;
}

public String getRoom(){
    return this.room;
}
    
public String getPrerequisite(){
    return this.presubject;
}  

public String getCourseDayAndTime(){
    return this.dayOfWeek+"'s,"+" starting at " + this.localTime;
}

public Instructor getInstructor(){
    return frank;
}

public int getClassSize(){
    return this.classSize;
}

/**
 * This method will take Student class variable and stores into classList
 * @param s
 * @return 
 */
public String addStudent(Student s){
    
    if(!s.inGoodStanding()){
        this.s = s;
        this.age = s.getAge();
        return "The Student is not in good standing and cannot join the course.";
       
    }
    else if(classList.length >= 3){
        this.age = s.getAge();
        this.s = s;
        return "Student was not added because the course is full";        
    }else{
            this.s = s;
            this.age = s.getAge();  

            classList[count] += s;
            count++;
         return "Student added";
    }
}

/**
 * This method can set the class size, Maximum number is 40, when the number is more than that it sets as 40.
 * @param size
 * @return 
 */
public String setClassSize(int size){
    if(size >= 40){
    this.classSize = 40;
    return "Max class size = 40, it has been set to 40";
    
    }else{
    this.classSize = size;
    return "Class size = " + size + " it has been set to " + size;
        
    }

}

/**
 * This method returns true is the average of age in the class is more than 25.
 * @return 
 */
public boolean matureClass(){
    
    return this.age >= 25;
}


public String showClassList(){
    return s.toString();
}

    public String toString(){
    return subject+"-"+courseName;
    }
    
}
