
package com.mycompany.breadthfirstsearch;


import static com.mycompany.breadthfirstsearch.Breadth.Breadth;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Breadth{
    public static void Breadth(int [][] g, int start){
        int n  = g.length;
        int[] visited = new int[n];
        Queue <Integer> q = new LinkedList<>();
        visited[start] = 1;
        q.offer(start);
        while(!q.isEmpty()){
            int current = q.poll();
            System.out.print(current +" ");
            for (int i = 0; i < n; i++) {
                if(g[current][i] == 1 && visited[i] == 0){
                    visited[i] = 1;
                    q.offer(i);
                }
            }
        }
        
    }
}

public class BreadthFirstSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        int[][] g = new int[n][n];
        System.out.println("Enter adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                 g[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter starting nodes: ");
        int m = sc.nextInt();
        System.out.println("BFS traversal: ");
        Breadth(g,m);
        
    }
}
