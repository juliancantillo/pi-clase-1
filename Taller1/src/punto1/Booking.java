/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto1;

/**
 *
 * @author Usuario
 */
public class Booking {
    
    private static int computers[][];
    private static int freeComputers[];

    public Booking() {
        computers = new int[3][30];
        freeComputers = new int[3];
    }

    /**
     * Reserves a computer form the avaible computers
     * @param room
     * @param pc
     * @return true or false if the reserve have been realized
     */
    public boolean reserve( int room, int pc ){     
        int computer = getComputers(room, pc);
        
        if( computer == 1 ){
            return false;
        }else{
            setComputers(room, pc, 1);
            return true;
        }
    }

    /**
     * Cancels a booking
     * @param room
     * @param pc
     * @return true or false if the reserve have been realized
     */
    public boolean cancel( int room, int pc ){     
        int computer = getComputers(room, pc);
        
        if( computer == 0 ){
            return false;
        }else{
            setComputers(room, pc, 0);
            return true;
        }
    }
    
    public String availableComputers(){
        int[] available = new int[ Booking.computers.length ];
        
        for (int i = 0; i < Booking.computers.length; i++) {
            int[] tmpComputers = computers[i];
            for (int j = 0; j < tmpComputers.length; j++) {
                if( tmpComputers[j] == 0 ){
                    available[i]++;
                }
            }
        }
        
        String response = "Sala 1: " + available[0] + "\n"
                + "Sala 2: " + available[1] + "\n"
                + "Sala 3: " + available[2];
        
        return response;
    }
        
    public String takenComputers(){
        int taken = 0;
        
        for (int[] tmpComputers : Booking.computers) {
            for (int i : tmpComputers) {
                if( i == 1 ){
                    taken++;
                }  
            }
        }
        
        String response = "Turnos asignados: " + taken;
        
        return response;
    }
    
    public static int[][] getComputers() {
        return computers;
    }
    
    public static int[] getComputers(int idx) {
        return computers[idx];
    }
    
    public static int getComputers(int idx, int idy) {
        return computers[idx][idy];
    }

    public static void setComputers(int idx, int idy, int value) {
        Booking.computers[idx][idy] = value;
    }
    
}
