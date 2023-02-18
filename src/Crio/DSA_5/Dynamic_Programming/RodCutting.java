package Crio.DSA_5.Dynamic_Programming;
import java.util.*;


class RodCutting{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int price[]=new int[n];
        for(int i=0;i<n;i++)
        {
            price[i]=sc.nextInt();
        }
        System.out.println(rodCutting(n, price));
        sc.close();
    }

    static int rodCutting(int n, int price[]){
        int[] dp = new int[n+1];
        int maxVal = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal,price[j] + dp[i-j-1]);
            }
            dp[i] = maxVal;
        }

        return dp[n];
    }
}
