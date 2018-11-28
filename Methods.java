/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nguyen Quyet
 */
public class Methods {
    
    public static int takeARandomNumberIn(int arr[][]){
        
        int randomNumber,row,col;
            Random rand = new Random();
            do {
            
                randomNumber = rand.nextInt(81);
                row = randomNumber/9;
                col = randomNumber % 9;
              
                
            } while (arr[row][col] == 0);
        
            
            
        return randomNumber;
    }
    
    public static int[][] createBlankSquare(){
        int arr[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = 0;
            }
        }
        
        return arr;
    }
    
    public static int[][] creatSquare9x9(){
        
        int arr[][] = new int[9][9];
        int count[] = new int[9];
        for (int i = 0; i < 9; i++) {
            count[i]=0;
        }
        int t;
        Random rand = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                do {
                    t = rand.nextInt(9)+1;
                } while (count[t-1] == 9);
                arr[i][j]=t;
                count[t-1]++;
            }
        }
        
        return arr;
    }
   
    
    public static void printSquare(int a[][]){
        System.out.flush();
        System.out.print("   ");
        for (int i = 0; i < 9; i++) {
            
            if ((i+1)%3 == 0) {
                System.out.print(i+ "|");
            }else{
                System.out.print(i + " ");
            }
        }
        
        System.out.println();
        System.out.println();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(j == 0){
                        System.out.print(i + " |");
                    }
                
                if ((j+1)%3 == 0) {
                    if (a[i][j]==0) {
                        System.out.print(" |");
                    }else{
                        System.out.print(a[i][j]+"|");
                    }
                        
                        
                }else
                    if (a[i][j]==0) {
                    System.out.print("  ");
                    }else{
                     System.out.print(a[i][j]+" ");
                    }
                       
                        
                }
            if ((i+1)%3 == 0) {
                System.out.println();
            }
                System.out.println();
            }
        System.out.println();
       
        }

 
    public static boolean checkNumberSatified(int a[][],ArrayList al,int rowA,int colA){
       int n;
        for (int i = 0; i < al.size(); i++) {
            
                n = (int) al.get(i);
            if (Methods.checkNumberIsOkey(a, rowA, colA, n)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkNumberIsOkey(int a[][],int row,int col,int number){
       return (!Methods.checkNumberInCol(a, col, number) && !Methods.checkNumberInRow(a, row, number) && !Methods.checkNumberInSquare(a, row, col, number));
    }
    
    public static boolean checkNumberInRow(int a[][],int row,int number){
        for (int i = 0; i < 9; i++) {
            if (a[row][i] == number) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkNumberInCol(int a[][],int col,int number){
        for (int i = 0; i < 9; i++) {
            if (a[i][col] == number) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkNumberInSquare(int a[][],int row,int col,int number){
        if (row>=0 && row <3) {
            if(col>=0 && col <3){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (a[i][j]==number) {
                            return true;
                        }
                    }
                    
                }
            }
            if(col>=3 && col <6){
                 for (int i = 0; i < 3; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (a[i][j]==number) {
                            return true;
                        }
                    }
                    
                }
            }
            if(col>=6 && col <9){
                 for (int i = 0; i < 3; i++) {
                    for (int j = 6; j < 9; j++) {
                        if (a[i][j]==number) {
                            return true;
                        }
                    }
                    
                }
            }
        }
        if (row>=3 && row <6) {
            if(col>=0 && col <3){
                 for (int i = 3; i < 6; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (a[i][j]==number) {
                            return true;
                        }
                    }
                    
                }
            }
            if(col>=3 && col <6){
                for (int i = 3; i < 6; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (a[i][j]==number) {
                            return true;
                        }
                    }
                    
                }
            }
            if(col>=6 && col <9){
                for (int i = 3; i < 6; i++) {
                    for (int j = 6; j < 9; j++) {
                        if (a[i][j]==number) {
                            return true;
                        }
                    }
                    
                }
            }
        }
        if (row>=6 && row <9) {
            if(col>=0 && col <3){
                for (int i = 6; i < 9; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (a[i][j]==number) {
                            return true;
                        }
                    }
                    
                }
            }
            if(col>=3 && col <6){
                for (int i = 6; i < 9; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (a[i][j]==number) {
                            return true;
                        }
                    }
                    
                }
            }
            if(col>=6 && col <9){
                for (int i = 6; i < 9; i++) {
                    for (int j = 6; j < 9; j++) {
                        if (a[i][j]==number) {
                            return true;
                        }
                    }
                    
                }
            }
        }
        return false;
    }
    
    public static ArrayList toArrayList(int[][] a){
        ArrayList al = new ArrayList();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                    al.add(a[i][j]);
                }
        }
        
        return al;
        }
        
    public static int pickARandomNumberInArrayList(ArrayList a){
        Random rd = new Random();
        int n = rd.nextInt(a.size());
        return n;
    }
    
    public static void printArrayList(ArrayList al){
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i)+" ");
        }
        System.out.println();
    }
    
    public static ArrayList copyArrayList(ArrayList al){
        ArrayList al1 = new ArrayList();
        for (int i = 0; i < al.size(); i++) {
            al1.add(al.get(i));
        }
        return al1;
    }
    
    public static int[][] copyMatrix(int[][] a){
        int[][] a1 = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(a[i], 0, a1[i], 0, 9);
        }
        return a1;
    }
    
    public static boolean solveSudoku(int[][] a){
        int row = -1,col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j]  == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty)
                break;
        }
        
        if(isEmpty)
            return true;
        
        for (int i = 1; i <=9; i++) {
            if(Methods.checkNumberIsOkey(a, row, col, i)){
                  a[row][col] = i;
                  if (Methods.solveSudoku(a)){ 
                    return true;  
                  }else{
                    a[row][col] = 0;
                   }
            }
        }
        return false;
    }
    
    public static int[][] sudokuGenerator(){
        int arr[][] = Methods.creatSquare9x9();
        int arr1[][] = Methods.createBlankSquare();
        boolean check = false;
        
        ArrayList al = Methods.toArrayList(arr);
        
        
        int t,count = 0,i,j,n;
        
        
        do {
            i = count / 9;
            j = count % 9 ;
            
                    
               do {
                   if (!Methods.checkNumberSatified(arr1, al, i,j)) {
                        check = true;
                    }
                        t = Methods.pickARandomNumberInArrayList(al);
                        n = (int) al.get(t);
                    if(check)
                         break;
               } while (Methods.checkNumberInCol(arr1, j,n)||Methods.checkNumberInRow(arr1, i, n)||Methods.checkNumberInSquare(arr1, i, j,n));
                 if(check)
                    break;
                arr1[i][j]=n;
                al.remove(t);
                count++;
               
        } while (count<81);
        
        
     
        int[][] copyArr = Methods.copyMatrix(arr1);
        
         do {
            i = count / 9;
            j = count % 9 ;
                do {
                   
                       if (!Methods.solveSudoku(copyArr)) {
                           count--;
                            i = count / 9;
                            j = count % 9 ;
                           al.add(arr1[i][j]);
                           arr1[i][j]=0;
                           
                       }
                      
                    
                        t = Methods.pickARandomNumberInArrayList(al);
                        n = (int) al.get(t);

               } while (!Methods.checkNumberIsOkey(arr1, i, j, n));

                arr1[i][j]=n;
                al.remove(t);
                
                copyArr = Methods.copyMatrix(arr1);
                
                count++;
               
        } while (count<81);
        
       
         return arr1;
    
    }
    
    public static void hideSudoku(int[][] a){
        Random  rd = new Random();
        int n;
        for (int i = 0; i < 30; i++) {
            do {
                n = rd.nextInt(81);
            } while (a[n/9][n%9]==0);
            a[n/9][n%9]=0;
        }
    }
    
    public static int askChoice(int[][] arr){
        
        int choice;
        do {
            Methods.printSquare(arr);
        System.out.println("Type 1.Enter the number ");
        System.out.println("Type 2.Delete number");
        System.out.println("Type 3.Print solve");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
        } while (choice<1 || choice>3 );
    return choice;
    }
    
    public static void enterNumber(int[][] a){
        int row,col,number;
        
        do {
            Methods.printSquare(a);
            System.out.println("Which row you want ? ");
            Scanner sc = new Scanner(System.in);
            row = sc.nextInt();
        } while (row<0||row>8);
        do {
            Methods.printSquare(a);
            System.out.println("Which col you want ? ");
            Scanner sc = new Scanner(System.in);
            col = sc.nextInt();
        } while (col<0||col>8);
        do {
            Methods.printSquare(a);
            System.out.println("Which number you want ? ");
            Scanner sc = new Scanner(System.in);
            number = sc.nextInt();
        } while (number<1||number>9);
        a[row][col] = number;
    }
    
    public static void deleteNumber(int[][] a){
        
        int row,col;
        do {
            Methods.printSquare(a);
            System.out.println("Which row you want ? ");
            Scanner sc = new Scanner(System.in);
            row = sc.nextInt();
        } while (row<1||row>9);
        do {
            Methods.printSquare(a);
            System.out.println("Which col you want ? ");
            Scanner sc = new Scanner(System.in);
            col = sc.nextInt();
        } while (col<1||col>9);
        
        a[row][col] = 0;
    }
 }
    

