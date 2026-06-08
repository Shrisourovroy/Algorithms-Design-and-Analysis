

package fractionalknapsackalgo;

import java.util.Arrays;
import java.util.Scanner;

class Item{
    int w,p;
    double r;
    Item(int w, int p){
        this.w = w;
        this.p = p;
        r = (double)p/w;
    }
}


 class FractionalKnapsack{
    double MaxProfit(Item[] it, int cap){
        Arrays.sort(it,(a,b)->Double.compare(b.r,a.r));
        double MaxP = 0;
        System.out.println("Taken item: ");
        for(Item x : it){
            if(cap==0){
                break;
            }
            if(x.w<=cap){
                MaxP = MaxP+x.p;
                cap = cap - x.w;
                System.out.println(" "+x);
            }
            else{
                MaxP = MaxP + (x.r*cap);
                
                break;
            }
        }
       return MaxP; 
    }
}

public class FractionalKnapsackAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbre of item: ");
        int n = sc.nextInt();
        Item[] it = new Item[n];
        System.out.println("Enter item weight and value: ");
        
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int p = sc.nextInt();
            it[i] = new Item(w,p);
        }
        FractionalKnapsack fk = new FractionalKnapsack();
        System.out.println("Enter knapsack capasity: ");
        int cap = sc.nextInt();
        double profit = fk.MaxProfit(it, cap);
        
        System.out.println("Maximum profit: "+profit);
        
    }
}
