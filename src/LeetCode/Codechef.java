package LeetCode;
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int j = 0; j < n; j++) {
                A[j] = sc.nextInt();
            }
            System.out.println(ansWer(A,n));
        }
    }

    private static int ansWer(int[] A, int N) {
        int[] dp = new int[N+1];
        Arrays.fill(dp,-1);
        dp[1] = A[0];
        for (int i = 1; i < N; i++) {
            for (int j = i; j < Math.min(i + A[i],N); j++) {
                if (dp[j] == -1) dp[j] = dp[i] | A[j];
                else dp[j] = Math.min(dp[j], dp[i] | A[j]);
            }
        }
        return dp[N];
    }
}
