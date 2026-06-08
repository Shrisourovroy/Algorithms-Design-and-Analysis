
package com.mycompany.greedyalgorithm;

import java.util.Scanner;


public class PrimsAlgorithm {
    static int minKey(int key[], int mstSet[], int V){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < V; i++) {
            if(mstSet[i] == 0 && key[i]<min){
                min = key[i];
                index = i;
            }
        }
        return index;
    }
    
    static void primsMST(int g[][], int V){
        int parent[] = new int[V];
        int key[] = new int[V];
        int mstSet[] = new int[V];
        
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = 0;
        }
        key[0] = 0;
        parent[0] = -1;
        
        for (int count = 0; count < V-1; count++) {
            int u = minKey(key,mstSet,V);
            mstSet[u] = 1;
              
            for (int v = 0; v < V; v++) {
                if(mstSet[v] == 0 && g[u][v] != 0 && g[u][v]<key[v]){
                    key[v]= g[u][v];
                    parent[v] = u;
                }
            }
                    
        }
        
        printMST(parent,g,V);
        
        
    }
    
    
    static void printMST(int parent[], int g[][], int V){
        int total = 0;
        System.out.println("Edge\tcost");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i]+"-"+i+"->"+g[i][parent[i]]);
            total += g[i][parent[i]];
        }
        System.out.print("Total cost: "+total);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertex: ");
        int v = sc.nextInt();
        int g[][] = new int[v][v];
        System.out.println("Enter the adjacency matrix of graph: ");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                g[i][j]= sc.nextInt();
            }
        }
        
        primsMST(g,v);
    }
            
            
}
