package Crio.DSA_5.Dynamic_Programming;

import java.util.*;

class TripleStep {
    int numberOfWays(int n) {
        if(n == 1) return 1;

        double[] dp = new double[n+1];
        double M =  (1e9 + 7);
        dp[0] = 1;  dp[1] = 1;  dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1]%M + dp[i-2]%M + dp[i-3]%M)%M;
        }

        return (int) (dp[n]%M);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TripleStep tripleStep = new TripleStep();
        int result = tripleStep.numberOfWays(n);
        System.out.println(result);
        scanner.close();
    }
}
