/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto3;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class Parking {
    
    private Vehicle[][] grid;
    private final int truckLimit = 6; //Limite de carros como camiones o pickups

    public Parking() {
        grid = new Vehicle[6][6];
        
        for (Vehicle[] vehicles : grid) {
            for (Vehicle vehicle : vehicles) {
                vehicle = null;
            }
        }
    }
    
    public boolean checkAvailability(boolean isTruck){
        
        int init = isTruck ? 0 : 1;
        int length = isTruck ? 1 : grid.length;
        
        for (int i=init ; i < length; i++) {
            for (Vehicle vehicle : grid[i]) {
                if(vehicle == null){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isFull(){
        for (Vehicle[] vehicles : grid) {
            for (Vehicle vehicle : vehicles) {
                if( vehicle == null )
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean addVehicle(Vehicle v){
        if( !isFull() ){
            
        }
        return true;
    }
    
    
}
