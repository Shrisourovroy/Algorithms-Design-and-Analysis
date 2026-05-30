

package com.mycompany.topologicalsortdfs;

import java.util.Scanner;
import java.util.Stack;

class TopoS{
    int g[][], prev[], dist[],col[],n, time;
    Stack <Integer> st = new Stack<>();
    TopoS(int g[][], int n){
        this.g = g;
        this.n = n;
        prev = new int[n];
        dist = new int[n];
        col = new int[n];
        
        for (int i = 0; i < n; i++) {
            prev[i] = -1;
        } 
    }
    
    void VisitDFS(int x){
        if(col[x]!= 2){
            col[x] = 1;
            dist[x] = ++time;
            
            for (int v = 0; v < n; v++) {
                if(g[x][v] == 1 && col[v] == 0){
                    col[v] = 1;
                    prev[v] = x;
                    VisitDFS(v);
                }
            }  
            col[x] = 2;
            st.push(x);
            dist[x] = ++time;
            
        }
    }
     void print(){
        System.out.print("Topological Sorting order: ");
           while(!st.isEmpty()){
               int x = st.pop();
               System.out.print(" "+x);
           }
        }
}





public class TopologicalSortDFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Node: ");
        int n = sc.nextInt();
        System.out.println("Enter the adjacency matrix of the graph: ");
        int g[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        
        TopoS tp = new TopoS(g,n);
        
        for (int i = 0; i < n; i++) {
            tp.VisitDFS(i);
        }
        
        tp.print();
        
    }
}
