
package com.mycompany.rabinkarpalgo;

import java.util.Scanner;


public class RabinKarpAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Text: ");
        String text = sc.next();
        System.out.println("Enter pattern: ");
        String pattern = sc.next();
        int n = text.length();
        int m = pattern.length();
        
        int p = 0;
        for (int i = 0; i <m ; i++) {
            p = 2*p + pattern.charAt(i);
        }
        System.out.println("Pattern value: "+p);
        
        for (int i = 0; i <= n-m; i++) {
            int q = 0;
            for (int j = 0; j <m; j++) {
                q = 2*q+text.charAt(j+i);
                if(q == p){
                    System.out.println("Found at the position: "+i);
                }   
            }  
        }   
    }
}
