package Crio.DSA_5.Dynamic_Programming;
import java.util.*;

class EqualSumPartition{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(equalSumPartition(n,arr));
        sc.close();
    }

    static int equalSumPartition(int n,int[] arr){
        int sum = 0;
        for(int a : arr) sum += a;
        boolean [][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++)    dp[i][0] = true;
        if(sum%2 == 0){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum/2; j++) {
                    dp[i][j] = dp[i-1][j];
                    if(arr[i-1] <= j) dp[i][j] = dp[i][j] || dp[i-1][j - arr[i-1]];
                }
            }
            return dp[n][sum/2] ? 1 : 0;
        }
        return 0;
    }

}

/*
Recursive Top Down + Memoization
    static int [][] dp;
    static boolean ans;
    static int equalSumPartition(int n,int[] arr){
        int sum = 0;
        for(int a : arr) sum += a;
        dp = new int[n+1][sum+1];
        for(int [] x : dp) Arrays.fill(x,-1);

        if(sum%2 == 0){
            return solve(sum/2,n,arr);
        }
        return 0;
    }

    private static int solve(int target, int n, int[] arr) {
        if(n == 0) return target == 0 ? 1 : 0;
        if(target == 0) return 1;
        if(dp[n][target] != -1) return dp[n-1][target];

        ans = solve(target,n-1,arr) == 1 || ans; //not pick
        if(target >= arr[n-1]) ans = solve(target - arr[n-1],n-1,arr) == 1 || ans; //pick
        dp[n][target] = ans ? 1 : 0;

        return ans ? 1 : 0;

    }
 */