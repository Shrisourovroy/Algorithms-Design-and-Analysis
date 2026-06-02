
package com.mycompany.activityselectionproblemalgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Activity{
    int start;
    int finish;
    Activity(int start, int finish){
        this.start = start;
        this.finish = finish;
    }
}

class ActiSel{
    void acSelect(Activity[] a, int n){
        Arrays.sort(a,Comparator.comparingInt(x->x.finish));
        int lastF = a[0].finish;
        System.out.println("Selected Activity: ");
        System.out.println("("+a[0].start+","+a[0].finish+")");
        for (int i = 1; i < n; i++) {
            if(a[i].start>=lastF){
                System.out.println("("+a[i].start+","+a[i].finish+")");
                lastF = a[i].finish;
                
            }
        }
    }
}



public class ActivitySelectionProblemAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of activity: ");
        int n = sc.nextInt();
        Activity[] ac = new Activity[n];
        System.out.println("Enter start and ending time of each activity: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("For element number: "+(i+1));
            System.out.print("Start time: ");
            int s = sc.nextInt();
            System.out.print("Finish time: ");
            int f = sc.nextInt();
            
            ac[i] = new Activity(s,f);
        }
        
        ActiSel obj = new ActiSel();
        obj.acSelect(ac, n);
    }
}
