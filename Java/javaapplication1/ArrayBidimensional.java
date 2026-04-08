/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Scanner;

/**
 *
 * @author guest-beu8q9
 */
public class ArrayBidimensional {
    
    public static void main(String[] args) {
        
        System.out.print("Entra la mida de la primera dimensió\n");
        Scanner input = new Scanner(System.in);
        String data;
        int dimensio;
        do {
            data = input.nextLine();
            dimensio = Integer.parseInt(data);
        } while (dimensio < 1);
        int[][] dimensions = new int[dimensio][];
        for (int compt = 0; compt < dimensions.length; compt++) {
            System.out.print("Entra la mida de la segona dimensió en la dimensio "+compt+"\n");
            data = input.nextLine();
            dimensio = Integer.parseInt(data);
            dimensions[compt] = new int [dimensio];
        }
        for (int[] omplir1 : dimensions) {
            java.util.Arrays.fill(omplir1, omplir1.length);
            System.out.print(java.util.Arrays.toString(omplir1)+"\n");
        }
        input.close();
        
    }
    
}