/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto2;

import java.util.ArrayList;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class Student {
    
    private String code;
    private String name;
    private String career;
    private ArrayList<Enrolment> enrolments;

    Student(String name, String code, String career) {
        this.code = code;
        this.name = name;
        this.career = career;
        this.enrolments = new ArrayList();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }
    
    public boolean addCourseToEnrolments( String period, Course course ){
        
        if( !isEnrolledToCourse(course) ){
            this.enrolments.add( new Enrolment(period, course) );
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isEnrolledToCourse(Course course){
        for (Enrolment enrolment : enrolments) {
            if(enrolment.getCourse().getCode().equals( course.getCode() )){
                return true;
            }
        }
        
        return false;
    }
    
    public String getEnrolledCoursesList(){
        String coursesList = "";
        Course course = null;
        
        for (Enrolment enrolment : enrolments) {
            course = enrolment.getCourse();
            coursesList += "[ "+ course.getCode() +" ] " + course.getName() + "\n";
        }
        
        return coursesList;
    }
 
    
}