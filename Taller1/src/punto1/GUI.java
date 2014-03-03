/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto1;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class GUI {
    
    Booking booking;
    public final String
            WELCOME_MSG = "Digite una opción:\n"
            + "[1] Asignar Turno\n"
            + "[2] Cancelar Turno\n"
            + "[3] Equipos Disponibles\n"
            + "[4] Turnos Asignados\n"
            + "[5] Salir",
            RESERVE_ROOM_MSG = "En que sala desea hacer la reservación ( Números del 1 al 3 )",
            RESERVE_PC_MSG = "En que equipo desea hacer la reservación ( Números del 1 al 30 )",
            CANCEL_ROOM_MSG = "En que sala desea hacer la cancelación ( Números del 1 al 3 )",
            CANCEL_PC_MSG = "En que equipo desea hacer la cancelación ( Números del 1 al 30 )",
            RESERVE_DONE = "Se realizó la reserva",
            RESERVE_FAIL = "No se realizó la reserva debido a que ya había sido tomado",
            VALID_PC_ERROR = "Solamente se pueden seleccionar equipos posibles ( Números del 1 al 30 )",
            VALID_ROOM_ERROR = "Solamente existen 3 salas ( Números del 1 al 3 )",
            CANCEL_DONE = "Se realizó la cancelación",
            CANCEL_FAIL = "No se realizó la cancelación debido a que no había reserva.";

    public GUI() {
        this.booking = new Booking();
        int option = 0;
        do{
            try{
                option = Integer.parseInt(
                        JOptionPane.showInputDialog(null, WELCOME_MSG));
            } catch (NumberFormatException e) {
                System.out.println("Error");
                System.exit(0);
            }
            
            switch(option){
                case 1:
                    this.reserve();
                    break;
                case 2:
                    this.cancel();
                    break;
                case 3:
                    this.available();
                    break;
                case 4:
                    this.taken();
                    break;
                default:
                    break;
            }
        }while( option != 5 );
        
        System.exit(0);
        
    }
    
    public final void reserve(){
        boolean valid = false;
        int room, pc;
        do{
            do{
                room = Integer.parseInt(
                    JOptionPane.showInputDialog(null, RESERVE_ROOM_MSG));

                if( room >= 1 && room <=3 ){
                    valid = false;
                }else{
                    JOptionPane.showMessageDialog(null, VALID_ROOM_ERROR);
                    valid = true;
                }
            }while(valid);

            do{
                pc = Integer.parseInt(
                    JOptionPane.showInputDialog(null, RESERVE_PC_MSG));

                if( pc >= 1 && pc <=30 ){
                    valid = false;
                }else{
                    JOptionPane.showMessageDialog(null, VALID_PC_ERROR);
                    valid = true;
                }
            }while(valid);
            
            if( booking.reserve(room - 1, pc - 1) ){
                JOptionPane.showMessageDialog(null, RESERVE_DONE);
                valid = false;
            }else{
                JOptionPane.showMessageDialog(null, RESERVE_FAIL);
                valid = true;
            }
            
        }while(valid);
            
    }
    
    public final void cancel(){
        boolean valid = false;
        int room, pc;
        do{
            do{
                room = Integer.parseInt(
                    JOptionPane.showInputDialog(null, CANCEL_ROOM_MSG));

                if( room >= 1 && room <=3 ){
                    valid = false;
                }else{
                    JOptionPane.showMessageDialog(null, VALID_ROOM_ERROR);
                    valid = true;
                }
            }while(valid);

            do{
                pc = Integer.parseInt(
                    JOptionPane.showInputDialog(null, CANCEL_PC_MSG));

                if( pc >= 1 && pc <=30 ){
                    valid = false;
                }else{
                    JOptionPane.showMessageDialog(null, VALID_PC_ERROR);
                    valid = true;
                }
            }while(valid);
            
            if( booking.cancel(room - 1, pc - 1) ){
                JOptionPane.showMessageDialog(null, CANCEL_DONE);
                valid = false;
            }else{
                JOptionPane.showMessageDialog(null, CANCEL_FAIL);
                valid = true;
            }
            
        }while(valid);
    }
    
    public final void available(){
        JOptionPane.showMessageDialog(null, booking.availableComputers());
    }
    
    public final void taken(){
        JOptionPane.showMessageDialog(null, booking.takenComputers());
    }
    
    
}
