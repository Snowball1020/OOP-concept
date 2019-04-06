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
public class CourseWithLab {

    private Instructor inst;
    private String courseNumber;
    private String courseName;
    private String room;
    private DayOfWeek dayOfWeek;
    private LocalTime localTime;
    private int size;
    private Instructor labGuy;
    private String room2;
    private DayOfWeek dayOfWeek2;
    private LocalTime localTime2;
    private String presubject;
    
    /**
     * Constructor for CourseWithLab (without having prerequisite variable)
     * @param inst
     * @param courseNumber
     * @param courseName
     * @param room
     * @param dayOfWeek
     * @param localTime
     * @param size
     * @param labGuy
     * @param room2
     * @param dayOfWeek2
     * @param localTime2
     * @throws IllegalArgumentException 
     */
    
    CourseWithLab(Instructor inst, String courseNumber, String courseName, String room, DayOfWeek dayOfWeek, LocalTime localTime, int size, Instructor labGuy, String room2, DayOfWeek dayOfWeek2, LocalTime localTime2) throws IllegalArgumentException{

    this.inst = inst;
    this.courseNumber = courseNumber;
    this.courseName = courseName;
    this.room = room;
    this.dayOfWeek = dayOfWeek;
    this.localTime = localTime;
    this.size =  size;
    this.labGuy = labGuy;
    this.room2 = room2;
    this.dayOfWeek2 = dayOfWeek2;
    this.localTime2 = localTime2;
    
    if(courseNumber.equalsIgnoreCase("COMP2008")){
    throw new IllegalArgumentException("Professor Alec Tricity is not qualified to teach COMP2008");
    }
    
    if(labGuy.getName().equalsIgnoreCase("Dan") && this.courseNumber.equalsIgnoreCase("COMP2008")){
    throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
    }

    
    }

    /**
     * Constructor for CourseWithLab with prerequisite
     * @param alec
     * @param courseNumber
     * @param courseName
     * @param room
     * @param dayOfWeek
     * @param localTime
     * @param size
     * @param presubject
     * @param labGuy
     * @param room2
     * @param dayOfWeek2
     * @param localTime2
     * @throws IllegalArgumentException 
     */
    
    CourseWithLab(Instructor alec, String courseNumber, String courseName, String room, DayOfWeek dayOfWeek, LocalTime localTime, int size, String presubject, Instructor labGuy, String room2, DayOfWeek dayOfWeek2, LocalTime localTime2) throws IllegalArgumentException {
    this.inst = alec;
    this.courseNumber = courseNumber;
    this.courseName = courseName;
    this.room = room;
    this.dayOfWeek = dayOfWeek;
    this.localTime = localTime;
    this.size =  size;
    this.presubject = presubject;
    this.labGuy = labGuy;
    this.room2 = room2;
    this.dayOfWeek2 = dayOfWeek2;
    this.localTime2 = localTime2;

    if(courseNumber.equalsIgnoreCase("COMP2008")){
    throw new IllegalArgumentException("Professor Alec Tricity is not qualified to teach COMP2008");
    }
    
    if(labGuy.getName().equalsIgnoreCase("Dan") && this.courseNumber.equalsIgnoreCase("COMP2008")){
    throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
    }

    
    }
    
    /**
     * Getter methods...
     * @return 
     */

    public String getPrerequisite(){
        return this.presubject;
    }
    
    public String getRoom(){
        return this.room;
    }
    
    public String getDayofWeek(){
        return this.getDayofWeek();
    }
    
    public String getLocalTime(){
    return this.getLocalTime();
    }    
    
    public String getLabClassAndTime(){
        return "room: " + this.room2 + ", " + this.dayOfWeek2 + " starting at " + this.localTime2;
    }
    
    public Instructor getInstructor(){
        return inst;
    }
    
    public Instructor getLabTech(){
        return labGuy;
    }
   
    
    /**
     * ToString to show firstName and lastName.
     * @return 
     */
    public String toString(){
        return this.courseNumber + "-"+this.courseName+" with lab";
    }

}
