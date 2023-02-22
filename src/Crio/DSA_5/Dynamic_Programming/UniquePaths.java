package Crio.DSA_5.Dynamic_Programming;
import java.io.*;
import java.util.*;
class UniquePaths {

    public int uniquePaths(int m, int n) {
        int M = 1000000007;
        int[][] dp = new int[m][n];

        //The number of unique paths to any cell in the first row or first column is 1
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < n; i++) dp[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (dp[i-1][j]%M + dp[i][j-1]%M)%M;
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();
        int result = new UniquePaths().uniquePaths(m , n);
        System.out.println(result);
    }
}

/*
//Recursive + Memoization
    static int[][] dp;
    static int M;
    public int uniquePaths(int m, int n) {
        M = 1000000007;
        dp = new int[m+1][n+1];
        for (int [] A: dp) Arrays.fill(A,-1);
        return solve(m,n,0,0);
    }

    private int solve(int m, int n, int i, int j) {
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = (solve(m,n,i+1,j)%M + solve(m, n, i, j+1)%M)%M;
    }
 */
