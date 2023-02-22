package Crio.DSA_5.Dynamic_Programming;

import java.util.*;

public class Coins {
    static int M = 1000000007;
    int countWays(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            if (i >= 5) dp[i] = (dp[i] + dp[i-5]) % M;
            if (i >= 25) dp[i] = (dp[i] + dp[i-25]) % M;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Coins result = new Coins();
        int n = scanner.nextInt();
        int answer = result.countWays(n);
        System.out.println(answer);
        scanner.close();
    }
}

/*
Recursive + Memoization
    static int[] dp;
    static int M = 1000000007;
    int countWays(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }

    private int solve(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];

        return dp[n] = (solve(n-1)%M + solve(n-5)%M + solve(n-25)%M)%M;
    }
 */