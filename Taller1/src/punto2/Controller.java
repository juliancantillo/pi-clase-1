/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 * 
 * This class controls all the entitys and join the models with the GUI
 */
public class Controller {
    
    private final ArrayList<Student> students;
    private final ArrayList<Course> courses;

    /**
     * Constructor
     * Initializes all the ArrayList
     */
    public Controller() {
        students = new ArrayList();
        courses = new ArrayList();
    }
    
    /**
     * Create and student object and add it into the ArrayList of Students
     */
    public void createStudent(){
        String name = JOptionPane.showInputDialog( R.STR_CREATE_STUDENT_NAME );
        String code = JOptionPane.showInputDialog( R.STR_CREATE_STUDENT_CODE );
        String career = JOptionPane.showInputDialog( R.STR_CREATE_STUDENT_CAREER );
        
        //Create the object with the variables captured above
        Student student = new Student( name, code, career );
        //The new object is added in the ArrayList
        students.add( student );
        
        System.out.println(student);
    }
    
    /**
     * Create a Course object and add it into the ArrayList of courses
     */
    public void createCourse(){
        String name = JOptionPane.showInputDialog( R.STR_CREATE_COURSE_NAME );
        String code = JOptionPane.showInputDialog( R.STR_CREATE_COURSE_CODE );
        int credits = Integer.parseInt( JOptionPane.showInputDialog( R.STR_CREATE_COURSE_CREDITS ) );
        
        //Create the object with the variables captured above
        Course course = new Course(name, code, credits);
        //The new object is added in the ArrayList
        courses.add( course );
        
        System.out.println(course);
    }
    
    /**
     * Find a Student with the given code, this uses for iterator in order to navigate all the ArrayList
     * @param code
     * @return Student
     */
    public Student findStudentByCode( String code ){
        Student temporal = null;
        
        for (Student student : students) {
            System.out.println( "Comparando " + student.getCode() + " con " + code );
            //This function is using Regex, so it can be improved
            if(student.getCode().matches( "^" + code + "$" )){
                return student;
            }
        }
        
        return null;
    }
    
    /**
     * Find a Course with the given code, this uses for iterator in order to navigate all the ArrayList
     * @param code
     * @return Course
     */
    public Course findCourseByCode( String code ){
        Course temporal = null;
        
        for (Course course : courses) {
            System.out.println( "Comparando " + course.getCode() + " con " + code );
            if(course.getCode().matches( "^" + code + "$" )){
                return course;
            }
        }
        
        return null;
    }
    
    /**
     * This create a Enrolment for a Student, the Student is found by a given code, the Course too.
     */
    public void enrolStudent(){
        Student student = null;
        Course course = null;
        
        String searchStudentByCode = JOptionPane.showInputDialog( R.STR_SEARCH_STUDENT_BY_CODE );
        //Find a Student by Code and Check if is not NULL
        student = findStudentByCode(searchStudentByCode);
        if( student != null ){
            //If there is a Student with the given code show its name
            JOptionPane.showMessageDialog(null, String.format( R.STR_FOUND_STUDENT, student.getName() ));
            //Then ask for the Course code
            String searchCourseByCode = JOptionPane.showInputDialog(R.STR_SEARCH_COURSE_BY_CODE);
            course = findCourseByCode(searchCourseByCode);
            
            if(course != null){
                //If the Course exits then show its Name and ask for Period
                JOptionPane.showMessageDialog(null, String.format( R.STR_FOUND_COURSE, course.getName() ));
                
                String period = JOptionPane.showInputDialog( R.STR_PERIOD_OF_THE_ENROLMENT );
                //Add the Course using addCourseToEnrolments from the Student object
                if(student.addCourseToEnrolments(period, course)){
                    JOptionPane.showMessageDialog(null, R.STR_STUDENT_HAVE_BEEN_ENROLLED);
                }else{
                    JOptionPane.showMessageDialog(null, R.STR_STUDENT_IS_ALL_READY_ENROLLED);
                }
                
            }else{
                //Show message if there is not Course with that code
                JOptionPane.showMessageDialog(null, R.STR_COURSE_NOT_FOUND );
            }
            
        }else{
            //Show message if there is not Student with that code
            JOptionPane.showMessageDialog(null, R.STR_STUDENT_NOT_FOUND );
        }
    }
    
    public void recordScoreToStudent(){
        Student student = null;
        Course course = null;
        String coursesList;
        
        String searchStudentByCode = JOptionPane.showInputDialog( R.STR_SEARCH_STUDENT_BY_CODE );
        
        student = findStudentByCode(searchStudentByCode);
        if( student != null ){
            
            String searchCourseByPeriod = JOptionPane.showInputDialog(R.STR_SEARCH_COURSE_BY_PERIOD);
            
            coursesList = student.getEnrolledCoursesList( searchCourseByPeriod );
            if(coursesList != null){
                String courseCode = JOptionPane.showInputDialog( String.format( R.STR_STUDENT_ENROLLED_COURSES, student.getName(), student.getCode(), coursesList ) );
                course = findCourseByCode(courseCode);
                
                if(course != null){
                    double score = Double.parseDouble( JOptionPane.showInputDialog( String.format( R.STR_RECORD_SCORE , student.getName(), student.getCode(), course.getName(), course.getCode()) ) );
                    
                    student.recordScore(score, searchCourseByPeriod, course);
                }
            }else{
                JOptionPane.showMessageDialog(null, String.format( R.STR_STUDENT_HAS_NOT_ENROLLED_COURSES, student.getName() ));
            }
            
        }else{
            JOptionPane.showMessageDialog(null, R.STR_STUDENT_NOT_FOUND );
        }
    }
    
    public void listEnrolledStudentsToCourse(){
        String studentList = "";
        Enrolment enrolment;
        
        String searchCourseByPeriod = JOptionPane.showInputDialog(R.STR_SEARCH_COURSE_BY_PERIOD);
        String searchCourseByCode = JOptionPane.showInputDialog(R.STR_SEARCH_COURSE_BY_CODE);
        Course course = findCourseByCode(searchCourseByCode);
        
        
        if( course != null ){
            for (Student student : students) {
                if( student.isEnrolledToCourse(searchCourseByPeriod, course) ){
                    enrolment = student.getEnrolmentByCourse(searchCourseByPeriod, course);
                    
                    String score = enrolment.getScore() != 0.0 ? Double.toString(enrolment.getScore()) : "";
                    
                    studentList +=  String.format( "[ %s-%s ] %s %s\n", student.getCode(), student.getCareer(), student.getName(), score);
                }
            }
            
            if(!"".equals(studentList)){
                JOptionPane.showMessageDialog(null, String.format( R.STR_ENROLLED_STUDENTS_LIST, course.getName(), course.getCode(), studentList ));
            }else{
                JOptionPane.showMessageDialog(null, String.format( R.STR_NOT_FOUND_ENROLLED_STUDENTS, course.getName(), course.getCode()));
            }
            
        }else{
            JOptionPane.showMessageDialog(null, R.STR_COURSE_NOT_FOUND );
        }
    }
    
    public void testing(){
        Student s1 = new Student("Julian", "31263", "3743");
        Student s2 = new Student("Andres", "54321", "3743");
        
        Course c1 = new Course("Progamación Interctiva", "PI001", 3);
        Course c2 = new Course("Algebra Lineal", "AL001", 3);
        
        courses.add(c1);
        courses.add(c2);
        
        students.add(s1);
        students.add(s2);
                
    }
    
}
