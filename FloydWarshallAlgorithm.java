
package com.mycompany.floydwarshallalgorithm;

import java.util.Scanner;

class FWA{
    int g[][];
    int n;
    FWA(int g[][], int n){
        this.g = g;
        this.n = n;
    }
    
    void floyd(){
        int i, j, k;
        
        for ( k = 0; k < n; k++) {
            for ( i = 0; i < n; i++) {
                for ( j = 0; j < n; j++) {
                    if(g[i][k] != 0 && g[k][j] != 0 && i != j ){
                        
                        if(g[i][j] == 0 || g[i][k] + g[k][j] < g[i][j]){
                            g[i][j] = g[i][k] + g[k][j];
                        }
                    }
                }
            }
            
        }
    }
    void print(){
        for (int i = 0; i < n; i++) {
            System.out.println("Minimum cost from node: "+i);
            for (int j = 0; j < n; j++) {
                System.out.print(g[i][j]+" ");
            }
            System.out.println();
        }
    }
}

public class FloydWarshallAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of node: ");
        int n = sc.nextInt();
        int [][] g = new int[n][n];
        System.out.println("Enter the graph: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextInt();
            }  
        }
        FWA f = new FWA(g,n);
           f.floyd();
           f.print();
    }
}
