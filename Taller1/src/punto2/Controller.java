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
 */
public class Controller {
    
    private final ArrayList<Student> students;
    private final ArrayList<Course> courses;

    public Controller() {
        students = new ArrayList();
        courses = new ArrayList();
    }
    
    public void createStudent(){
        String name = JOptionPane.showInputDialog( R.STR_CREATE_STUDENT_NAME );
        String code = JOptionPane.showInputDialog( R.STR_CREATE_STUDENT_CODE );
        String career = JOptionPane.showInputDialog( R.STR_CREATE_STUDENT_CAREER );
        
        Student student = new Student( name, code, career );
        
        students.add( student );
        
        System.out.println(student);
    }
    
    public void createCourse(){
        String name = JOptionPane.showInputDialog( R.STR_CREATE_COURSE_NAME );
        String code = JOptionPane.showInputDialog( R.STR_CREATE_COURSE_CODE );
        int credits = Integer.parseInt( JOptionPane.showInputDialog( R.STR_CREATE_COURSE_CREDITS ) );
        
        Course course = new Course(name, code, credits);
        
        courses.add( course );
        
        System.out.println(course);
    }
    
    public Student findStudentByCode( String code ){
        Student temporal = null;
        
        for (Student student : students) {
            System.out.println( "Comparando " + student.getCode() + " con " + code );
            if(student.getCode().matches( "^" + code + "$" )){
                return student;
            }
        }
        
        return null;
    }
    
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
    
    public void enrolStudent(){
        Student student = null;
        Course course = null;
        
        String searchStudentByCode = JOptionPane.showInputDialog( R.STR_SEARCH_STUDENT_BY_CODE );
        
        student = findStudentByCode(searchStudentByCode);
        if( student != null ){
            
            JOptionPane.showMessageDialog(null, String.format( R.STR_FOUND_STUDENT, student.getName() ));
            
            String searchCourseByCode = JOptionPane.showInputDialog(R.STR_SEARCH_COURSE_BY_CODE);
            course = findCourseByCode(searchCourseByCode);
            
            if(course != null){
                JOptionPane.showMessageDialog(null, String.format( R.STR_FOUND_COURSE, course.getName() ));
                
                String period = JOptionPane.showInputDialog( R.STR_PERIOD_OF_THE_ENROLMENT );
                
                if(student.addCourseToEnrolments(period, course)){
                    JOptionPane.showMessageDialog(null, R.STR_STUDENT_HAVE_BEEN_ENROLLED);
                }else{
                    JOptionPane.showMessageDialog(null, R.STR_STUDENT_IS_ALL_READY_ENROLLED);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, R.STR_COURSE_NOT_FOUND );
            }
            
        }else{
            JOptionPane.showMessageDialog(null, R.STR_STUDENT_NOT_FOUND );
        }
    }
    
    public void registrateCalificationToStudent(){
        Student student = null;
        Course course = null;
        String coursesList;
        
        String searchStudentByCode = JOptionPane.showInputDialog( R.STR_SEARCH_STUDENT_BY_CODE );
        
        student = findStudentByCode(searchStudentByCode);
        if( student != null ){
            
            coursesList = student.getEnrolledCoursesList();
            if(coursesList != null){
                
            }else{
                JOptionPane.showMessageDialog(null, String.format( R.STR_STUDENT_HAS_NOT_ENROLLED_COURSES, student.getName() ));
            }
            
        }else{
            JOptionPane.showMessageDialog(null, R.STR_STUDENT_NOT_FOUND );
        }
    }
    
    public void listEnrolledStudentsToCourse(){
        String studentList = "";
        Course course;
        
        String searchCourseByCode = JOptionPane.showInputDialog(R.STR_SEARCH_COURSE_BY_CODE);
        course = findCourseByCode(searchCourseByCode);
        
        if( course != null ){
            for (Student student : students) {
                if( student.isEnrolledToCourse(course) ){
                    studentList += "[ "+ student.getCode() + "-" + student.getCareer() +" ] " + student.getName() + "\n";
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
