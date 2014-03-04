/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto2;

import javax.swing.JOptionPane;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class Punto2 {
    
    private Controller controller;
    
    public Punto2() {
        controller = new Controller();
        controller.testing();
    }
    
    public void initMenu(){
        int option;
        do{
            option = Integer.parseInt( JOptionPane.showInputDialog(R.STR_MENU) );
            
            switch(option){
                case 1:
                    controller.createStudent();
                    break;
                
                case 2:
                    controller.createCourse();
                    break;
                
                case 3:
                    controller.enrolStudent();
                    break;
                
                case 4:
                    controller.recordScoreToStudent();
                    break;
                
                case 5:
                    break;
                
                case 6:
                    break;
                
                case 7:
                    controller.listEnrolledStudentsToCourse();
                    break;
                
                default:
                    break;
            }
            
        }while(option != 8);
        
        System.exit(0);
    }
    
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        Punto2 obj = new Punto2();
        obj.initMenu();
    }
}
