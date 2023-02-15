package Crio.DSA_5.Dynamic_Programming;
import java.util.*;


class CoinChange {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int N = sc.nextInt();
        int []coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        long ans = coinChange(A, N, coins);
        System.out.println(ans);
        sc.close();
    }



    public static long coinChange(int amount, int n, int []coins) {
        long[][] dp = new long[n][amount+1];
        for (int i = 0; i <= amount; i++) dp[0][i] = i % coins[0] == 0 ? 1 : 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                long notTake = dp[i-1][j];
                long Take = 0;
                if(coins[i] <= j) Take = dp[i][j - coins[i]];
                dp[i][j] = notTake + Take;
            }
        }

        return dp[n-1][amount];
    }

}

/*
Recursive + Memoization
    static long  ans;
    static long[][] dp;
    public static long coinChange(int amount, int n, int []coins) {
        dp = new long[n+1][amount+1];
        for (long [] A : dp) Arrays.fill(A,-1);
        return solve(coins,n,amount);
    }

    private static long solve(int[] coins, int n, int amount) {
        if(amount == 0) return 1;
        if(amount < 0) return 0;
        if(n <= 0) return 0;
        if(dp[n][amount] != -1) return dp[n][amount];

        return dp[n][amount] = solve(coins,n - 1,amount) + solve(coins,n,amount - coins[n - 1]);
    }
 */