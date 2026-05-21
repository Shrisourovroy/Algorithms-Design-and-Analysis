
package com.mycompany.stringmatching;

import java.util.Scanner;


public class StringMatching {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
        System.out.println("Enter Pattern : ");
        String pattern = sc.nextLine();
        System.out.println("Enter Text: ");
        String text = sc.nextLine();
        
        int n = pattern.length();
        int m = text.length();
        System.out.println("Founding position: ");
        for (int i = 0; i <=m-n; i++) {    //text
           int f = 1;
            for (int j = 0; j <n; j++) {    //pattern 
                if(pattern.charAt(j)!=text.charAt(i+j))
                {
                    f = -1;
                    break;
                }
            }
          if(f!=-1)System.out.println("Found at the position: "+i);  
        }    
    }
}
