package Crio.DSA_5.Dynamic_Programming;
import java.util.*;


class SubsetSum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,t;
        n=sc.nextInt();
        t=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        if(subsetSum(arr,t))
        {
            System.out.println(1);
        }
        else
        {
            System.out.println(0);
        }

    }

    static boolean subsetSum(int[] a, int sum){
        int n = a.length;
        boolean [][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++)    dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(a[i-1] <= j) dp[i][j] = dp[i][j] || dp[i-1][j - a[i-1]];
            }
        }
        return dp[n][sum];
    }
}

/*
Top Down Approach Recursive + Memoization
    static int [][] dp;
    static boolean ans;
    static boolean subsetSum(int[] a, int sum){
        dp = new int[a.length+1][sum+1];
        for(int [] x : dp) Arrays.fill(x,-1);
        return solve(a.length,sum,a);
    }

    private static boolean solve(int n, int sum, int[] A) {
        if(n == 0) return sum == 0;
        if(sum == 0) return true;
        if(dp[n-1][sum] != -1) return dp[n - 1][sum] != 0;

        ans = solve(n-1,sum,A) || ans; //not pick
        if(sum >= A[n-1]) ans = solve(n-1,sum - A[n-1],A) || ans; //pick
        dp[n][sum] = ans ? 1 : 0;

        return ans;
    }
 */