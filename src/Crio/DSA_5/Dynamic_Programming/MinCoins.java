package Crio.DSA_5.Dynamic_Programming;
import java.util.*;

class MinCoins{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int amt=sc.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++)
        {
            array[i]=sc.nextInt();
        }
        System.out.println(minCoins(array,amt));

    }

    static int minCoins(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int val = 1; val <= amount; val++) {
            for (int coin : coins) {
                if (coin <= val) {
                    int curRes = dp[val - coin];
                    if (curRes != Integer.MAX_VALUE && curRes + 1 < dp[val]) dp[val] = curRes + 1;
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

/*
//Recursion + Memoization
    static int[] dp;
    static int minCoins(int[] coins, int amount){
        dp = new int[coins.length+1];
        Arrays.fill(dp,-1);
        return solve(coins,amount,coins.length);
    }


    private static int solve(int[] coins, int amount,int n) {
        if(amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        if(dp[n] != -1) return 0;

        for (int i = 0; i < n; i++) {
            if(coins[i] <= amount){
                int curRes = solve(coins,amount - coins[i],n);
                if(curRes != Integer.MAX_VALUE) {
                    res = Math.min(curRes+1,res);
                    dp[i] = res;
                }
            }
        }
        return res;
    }
 */