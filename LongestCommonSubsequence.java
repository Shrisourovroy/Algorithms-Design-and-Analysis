
package com.mycompany.longestcommonsubsequence;

import java.util.Scanner;

class LCS{
    int Longest(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}




public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.println("Enter second string: ");
        String s2 = sc.nextLine();
        
        LCS lcs = new LCS();
        int length = lcs.Longest(s1, s2);
        System.out.print("Longest common sequence length: "+length);
        
    }
}
