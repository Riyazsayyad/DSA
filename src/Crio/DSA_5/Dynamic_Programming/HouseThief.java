package Crio.DSA_5.Dynamic_Programming;

import java.util.*;
class HouseThief {

    public static long houseThief(int n, int []arr) {
        long[] dp = new long[n+1];
        dp[1] = arr[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(arr[i-1] + dp[i-2],dp[i-1]);
        }
        return dp[n];
    }



    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int [n];
        for ( int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans = houseThief(n, arr);
        System.out.println(ans);

    }
}

/*
Memoization code
    static long[] dp;
    public static long houseThief(int n, int []arr) {
        dp = new long[n+1];
        Arrays.fill(dp,-1);
        return solve(n,arr);
    }

    private static long solve(int i, int[] arr) {
        if (i <= 0) return 0;
        if(dp[i] != -1) return dp[i];
        long ans = Math.max(arr[i-1] + solve(i-2,arr),solve(i-1,arr) );
        dp[i] = ans;
        return ans;
    }
 */