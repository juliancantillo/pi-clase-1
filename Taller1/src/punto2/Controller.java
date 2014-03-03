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
        
        students.add( new Student( name, code, career ) );
    }
    
    public void createCourse(){
        String name = JOptionPane.showInputDialog( R.STR_CREATE_COURSE_NAME );
        String code = JOptionPane.showInputDialog( R.STR_CREATE_COURSE_CODE );
        int credits = Integer.parseInt( JOptionPane.showInputDialog( R.STR_CREATE_COURSE_CREDITS ) );
        
        courses.add( new Course( name, code, credits ) );
    }
    
    public Student findStudentByCode( String code ){
        Student temporal = null;
        
        for (Student student : students) {
            if(student.getName().matches( "/^" + code + "$/i" )){
                
            }
        }
        
        return temporal;
    }
    
    
        
}
