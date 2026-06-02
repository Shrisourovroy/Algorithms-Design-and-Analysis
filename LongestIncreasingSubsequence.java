
package com.mycompany.longestincreasingsubsequence;

import java.util.Scanner;

class Longest{
    int arr[];
    int n;
    int l[];
    Longest(int arr[], int n){
        this.arr = arr;
        this.n = n;
        l = new int[n];  
    }
    
    void LIS(){
        for (int i = 0; i < n; i++) {
            l[i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    l[i] = Math.max(l[i],l[j]+1);
                }
            }
            
        }
        System.out.println("The length array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(l[i]+" ");
        }
        
       
        int MaxL = l[0];
        for (int i = 1; i < n; i++) {
            if(l[i]>MaxL){
                MaxL = l[i];
            }
        }
         System.out.print("\nMaximum Length of the subsequence: "+MaxL);
    }
}



public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter array element: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Longest lg = new Longest(arr,n);
        lg.LIS();
    }
}
