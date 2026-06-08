
package com.mycompany.hillclimbing;

import java.util.Scanner;
public class HillClimbing {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
        System.out.println("Enter table row size: ");
        int n = sc.nextInt();
        System.out.println("Enter table column size: ");
        int m = sc.nextInt();
        int [][] arr = new int[n][m];
        int [][] dp = new int[n][m];
        System.out.println("Enter climbing cost: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
            
        }
        
        for(int j = 0; j < m; j++) {
            dp[0][j] = arr[0][j]; //first row copy
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = dp[i-1][j];
                
               int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                
                if(j>0){
                    left = dp[i-1][j-1];
                }
                if(j<m-1){
                    right = dp[i-1][j+1];
                }
                
                dp[i][j] = arr[i][j] + Math.min(up,Math.min(left, right));
            }  
        }
        
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            result = Math.min(result, dp[n-1][j]);
        }
        //another option to find minimum cost
        /*int min = dp[n-1][0];
        for (int j = 1; j < m; j++) {
            if(min>dp[n-1][j]){
                min = dp[n-1][j];
            }
        }*/ 
        System.out.println("Minimum climbing cost: "+result);
        
    }
}
