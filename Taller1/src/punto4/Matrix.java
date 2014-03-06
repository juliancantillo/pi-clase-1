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
public class Matrix {

    private int[][] matrix;
    private int x, y, rows, cols;
    private int price;

    public Matrix(int[][] data) {
      this(data, 0, 0, data.length, data[0].length);
    }

    public Matrix(int[][] data, int x, int y, int rows, int cols) {
      this.matrix = data;
      this.rows = rows;
      this.cols = cols;
      this.x = x;
      this.y = y;
    }
    
    public Matrix getSubMatrix(int x, int y, int columns, int rows) {
        //Verificamos que la matriz sea posible
        if( ((x + (columns - 1)) > matrix.length) || (( y + (rows - 1)) > matrix[ this.x ].length ) ){
            return null;
        }
        return new Matrix(this.matrix, this.x + x , this.y + y, columns, rows);
    }
      
    public int getPrice() {
        
        int price = 0;
        
        if( ((x + (cols)) > this.matrix[ this.y ].length) || (( y + (rows)) > this.matrix.length ) ){
            System.out.println(String.format("La matrix no es válida %d, %d", (x + (cols)),  (y + (rows)) ) );
            return 0;
        }
        
        for (int i = y; i < y + rows; i++) {
            for (int j = x; j < x + cols; j++){
                
                //Si tiene lotes vendidos no sirve ;)
                try{
                    if( this.matrix[i][j] == -1 ){ System.out.println(String.format("Lote vendido en %d, %d", i, j)); return 0; }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.err.printf("--- Error en %d, %d \n", i, j );
                }
                
                
                price += this.matrix[i][j];
            }
        }
        
        this.price = price;
        
        System.out.println(String.format("SE encontró lote de precio: %d", price));
        
        return this.price;
    }
        
    public String toString() {

        StringBuffer sb = new StringBuffer();
        
        if( ((x + (cols)) > this.matrix[ this.y ].length) || (( y + (rows)) > this.matrix.length ) ){
            return null;
        }
        
        for (int i = y; i < y + rows; i++) {
            for (int j = x; j < x + cols; j++)
                sb.append(matrix[i][j]).append(" ");

            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }
    
    public int initX(){
        return x;
    }
    
    public int initY(){
        return y;
    }
    
    public int finalX(){
        return x + cols;
    }
    
    public int finalY(){
        return y + rows;
    }
    
    
}
