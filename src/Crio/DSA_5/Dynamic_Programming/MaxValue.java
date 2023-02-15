package Crio.DSA_5.Dynamic_Programming;
import java.util.*;

class MaxValue{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N,W;
        N=sc.nextInt();
        W=sc.nextInt();
        long val[] = new long[N];
        long wt[] = new long[N];
        for(int i=0;i<N;i++)
        {
            wt[i]=sc.nextLong();
        }
        for(int i=0;i<N;i++)
        {
            val[i]=sc.nextLong();
        }
        System.out.println(maxValue(W,wt,val));
    }

    static long maxValue(int W, long[] wt, long[] val){
        int n = wt.length;
        long[][] dp = new long [n+1][W+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j == 0) dp[i][j] = 0;
                else if (wt[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][(int)(j - wt[i-1])] + val[i-1]);
            }
        }
        return dp[n][W];
    }

}

/*
//Top Down - Recursive + Memoization
    static long[][] dp;
    static long ans;
    static long maxValue(int W, long wt[], long val[]){
        dp = new long [wt.length+1][W+1];
        for (long[] row : dp) Arrays.fill(row,-1);
        ans = 0;
        return solve(W,wt.length,wt,val);
    }

    private static long solve(int C, int n, long[] wt, long[] val) {
        if(n == 0 || C == 0) return dp[n][C] = 0;
        if(dp[n][C] != -1) return dp[n][C];

        dp[n][C] = Math.max(solve( C,n-1,wt,val),dp[n][C] );  //not pick
        if(C >= wt[n-1]) dp[n][C] = Math.max(solve((int) (C - wt[n-1]),n-1,wt,val) + val[n-1], dp[n][C]); //pick

        return dp[n][C];
    }
 */