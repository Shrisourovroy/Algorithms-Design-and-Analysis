

package matrixchainmultiplication;

import java.util.Scanner;

class MCM{
    int MatrixChain(int arr[], int n){
        int [][] m = new int[n][n];
        
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }
        
        for (int L = 2 ; L < n; L++) {
            for (int i = 1; i < n-L+1; i++) {
                int j = i+L-1;
                
                m[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k+1][j] +arr[i-1]*arr[k]*arr[j];
                    if(q<m[i][j])
                    {
                        m[i][j] = q;
                    }     
                }
                
            }
        }
        return m[1][n-1];
    }
}

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of matrix: ");
        int n = sc.nextInt();
        int [] dm = new int[n+1];
        System.out.println("Enter array dimention: ");
        for (int i = 0; i <=n; i++) {
            dm[i] = sc.nextInt();
        }
        MCM mcm = new MCM();
        int minMul = mcm.MatrixChain(dm, n+1);
        System.out.print("Minimum Number of multiplication: "+minMul);
        
    }
}
