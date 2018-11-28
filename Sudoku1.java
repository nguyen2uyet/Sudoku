/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nguyen Quyet
 */
public class Sudoku1 {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       int[][] arr = Methods.sudokuGenerator();
       int[][] arr1 = Methods.copyMatrix(arr);
       Methods.hideSudoku(arr);
       boolean check = false;
       
        do {
            int choice =  Methods.askChoice(arr);
            
            switch(choice){
                case 1:
                    Methods.enterNumber(arr);
                    break;
                case 2:
                    Methods.deleteNumber(arr);
                    break;
                case 3:
                    Methods.printSquare(arr1);1
                    check = true;
                    break;
            }
            if(check){
                break;
            }
        } while (true);
        
       
    
    }
}