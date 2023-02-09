package Crio.DSA_5.Dynamic_Programming;
import java.io.*;
import java.util.*;

public class ClimbingStairs {

    public int climbingStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;  dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfStairs = scanner.nextInt();
        scanner.close();
        int result = new ClimbingStairs().climbingStairs(numberOfStairs);
        System.out.print(result);
    }
}
