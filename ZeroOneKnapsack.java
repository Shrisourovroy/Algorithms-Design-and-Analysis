

package com.mycompany.zerooneknapsack;

import java.util.Scanner;

public class ZeroOneKnapsack {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of items: ");
        int n = sc.nextInt();
        int []w = new int[n];
        int []p = new int[n];
        System.out.println("Enter weight of each item: ");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        System.out.println("Enter profit of each item: ");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        
        System.out.println("Enter the knapsack capasity: ");
        int cap = sc.nextInt();
        
        int [][] dp = new int[n+1][cap+1];
        
        for (int i = 1; i <=n; i++) {
            for ( int j = 0; j <= cap; j++) {  //j means weight of knapsack
                if(w[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j], p[i-1]+dp[i-1][j-w[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("Maximum profit: "+dp[n][cap]);
        
        
    }
}
