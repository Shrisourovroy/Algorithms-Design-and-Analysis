
package com.mycompany.maxsubarraysum;

import java.util.Scanner;


public class MaxSubArraySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[9];
        int maxSum = 0;
        int curSum = 0;
      
        System.out.println("Enter Array Element: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i <arr.length; i++) {
            
                curSum = curSum+arr[i];
                maxSum = Math.max(curSum,maxSum);
            
            if(curSum<0){
                curSum = 0;
            }
        }
        System.out.println("Maximum sum: "+maxSum);
    }
}
