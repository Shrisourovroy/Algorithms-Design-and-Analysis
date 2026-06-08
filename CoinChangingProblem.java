
package com.mycompany.coinchangingproblem;

import java.util.Arrays;
import java.util.Scanner;


public class CoinChangingProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=0;
        System.out.println("Enter available coin number: ");
        int n = sc.nextInt();
        System.out.println("Enter available coin: ");
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Enter Total amount: ");
        int m = sc.nextInt();
        for (int i = n-1; i >=0; i--) {
            if(m%arr[i]==0){
                System.out.print(arr[i]+" ");
                count = count + m/arr[i];
            }
            else
            {
                if(m>arr[i]){
                System.out.print(arr[i]+" ");
                count = count +m/arr[i];
                m = m%arr[i];
                }
            }  
        }
        System.out.println("Minimum coin need: "+count);
        
    }
}
