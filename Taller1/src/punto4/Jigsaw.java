/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto4;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class Jigsaw {

    private int[][] map;
    private Matrix sample;
    private ArrayList<Matrix> solutions;
    

    public Jigsaw(int[][] map) {
        
        this.map = map;
        sample = new Matrix( this.map );
        solutions = new ArrayList();
//        
//        System.out.println("Size of full matrix: " + map.length + ", " + map[0].length);
//        
//        System.out.println("Part of the matrix:");
//        System.out.println(full.getSubMatrix(3, 3, 10, 10));
//        System.out.println(full.getSubMatrix(3, 3, 10, 10).getPrice());
        
    }
    
    public boolean analyze( int col, int row ){
        Matrix tmp = null;
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                tmp = sample.getSubMatrix(i, j, col, row);
                if( tmp != null && tmp.getPrice() > 0 ){
                    solutions.add(tmp);
                }
                tmp = sample.getSubMatrix(i, j, row, col);
                if( tmp != null &&  tmp.getPrice() > 0 ){
                    solutions.add(tmp);
                }
            }
        }
        
        return solutions.size() > 0;
    }
    
    public Matrix getLowestPrice(){
        int lowPrice = 999999999;
        Matrix lowestMatrix = null;
        
        for (Matrix object : solutions) {
            if( object.getPrice() < lowPrice ){
                lowestMatrix = object;
                System.out.println(String.format("Menor precio hasta ahora: %d", lowestMatrix.getPrice() ));
            }
        }
        
        return lowestMatrix;
    }
    
    public String showLowestPrices(){
        String response = "";
        
        for (Matrix obj : solutions) {
            response += obj.getPrice() + "\n";
        }
        
        return response;
    }
    
    public void playGame(){
        
        JOptionPane.showMessageDialog(null, "A continuación ingrese las dimensiones del terreno.");
        int row = Integer.parseInt( JOptionPane.showInputDialog("Número de Filas del Lote") );
        int cols = Integer.parseInt( JOptionPane.showInputDialog("Número de Columnas del Lote") );
        
        if(analyze(cols, row)){
            
            Matrix lowestPriceSolution = this.getLowestPrice();

            if( lowestPriceSolution != null ){
                String msg = String.format("El lote con el precio más bajo se encuentra en %d, %d hasta %d, %d.\n"
                        + "El precio de ese lote es: %d \n\n"
                        + "A continuación una muestra del lote\n%s" , lowestPriceSolution.initX(), lowestPriceSolution.initY(), lowestPriceSolution.finalX(), lowestPriceSolution.finalY(), lowestPriceSolution.getPrice(), lowestPriceSolution.toString());

                JOptionPane.showMessageDialog(null, msg);

            }else{
                JOptionPane.showMessageDialog(null, "Game Over");
            }
        
        }
        
    }

    
}
