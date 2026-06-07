
package com.mycompany.bfsshortestpath;

import static com.mycompany.bfsshortestpath.BFSshortest.BFS;
import static com.mycompany.bfsshortestpath.BFSshortest.print;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class BFSshortest{
    //s means start, dis means distance array, prev means previos 
    static void BFS(int [][]g, int n, int s, int [] dis, int prev[]){
        int []visited = new int[n];
        Queue<Integer> q = new LinkedList<>();
        
        visited[s] = 1;
        dis[s] = 0;
        q.add(s);
        
        while(!q.isEmpty()){
           int u = q.poll();
            for (int v = 0; v < n; v++) {
                if(g[u][v] == 1 && visited[v] == 0){
                    visited[v] = 1;
                    dis[v] = dis[u]+1;
                    prev[v] = u;
                    q.add(v);
                }
            }    
            
        }     
    }
    
    static void print(int s,int d, int prev[]){
        if(s == d){
            System.out.print(s);
            return;
        }
        
        print(s, prev[d], prev);
        System.out.print("->"+d);
                
    }
}


public class BFSShortestPath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of node: ");
        int n = sc.nextInt();
        int [][] g = new int[n][n];
        System.out.println("Enter adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        
        int [] prev = new int[n];
        int [] dis = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = -1;
            dis[i]= -1;
        }
        System.out.println("Enter source: ");
        int s = sc.nextInt();
        
        System.out.println("Enter destination: ");
        int d = sc.nextInt();
        
        BFS(g,n,s,dis,prev);
        
        System.out.println("Shortest distance: "+dis[d]);
        System.out.println("Shortest path: ");
        print(s,d,prev);
        
    }
}
