
package bellmanfordalgorithm;

import java.util.Scanner;

class Edge{
    int src,dest,weight;
    Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
// s means source, V means vertex, e means number of edge
class BellmanFord{
    
     static void bellmanford(Edge[] edges, int s, int V, int E){
         int dist[] = new int[V];
         
         for (int i = 0; i < V; i++) {
             dist[i] = Integer.MAX_VALUE;
         }
         dist[s] = 0;
         
         for (int i = 1; i < V; i++) { // this loop for relax V-1 time
             
             
             for (int j = 0; j < E; j++) {
             int u = edges[j].src;
             int v = edges[j].dest;
             int w = edges[j].weight;
                 if(dist[u]!= Integer.MAX_VALUE && dist[u]+w<dist[v]){
                     dist[v] = dist[u] + w;
                 }
             }
             
         }
         
         //for cheking negative edge
         for (int j = 0; j < E; j++) {
             int u = edges[j].src;
             int v = edges[j].dest;
             int w = edges[j].weight;
             if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                 System.out.println("This graph contain a negative cycle....");
                 return;
             }
         }
         
         System.out.println("Shortest path from source: "+s);
         for (int i = 0; i < V; i++) {
             System.out.println(i+"->"+dist[i]);
         }
     }
    
    
}

public class BellmanFordAlgorithm {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter the vertex number: ");
        int v = sc.nextInt();
        System.out.println("Enter the number of edge: ");
        int e = sc.nextInt();
        Edge [] edges = new Edge[e];
        System.out.println("Enter source destination and weight for each each: ");
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            
            edges[i] = new Edge(src,dest,weight);            
        }
        
        System.out.println("Enter the source vertex: ");
        int s = sc.nextInt();
        
        BellmanFord.bellmanford(edges,s,v,e);
    }
}
