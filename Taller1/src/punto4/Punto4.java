/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto4;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class Punto4 {
    
    static final int mapa[][] = {
        { -1, -1, -1, -1, -1, -1,},
        { -1, 45, 25,170, 82, -1,},
        { -1, -1, -1,198,103, 73,},
        { -1, -1, -1, -1, -1, -1,},
        { -1, -1, -1, -1,103, -1,},
        { -1, -1, -1, -1, -1, -1,},
    };
    
    
    public Punto4() {
        Jigsaw jigsaw = new Jigsaw( mapa );
        jigsaw.playGame();
    }
    
    public static void main( String[] args ){
        
        Punto4 obj = new Punto4();
        
    }
}
