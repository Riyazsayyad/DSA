package Crio.DSA_5.Dynamic_Programming;
import java.util.*;


class Donuts {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        List<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }
        long result = donuts(N, B, A);
        System.out.println(result);
        sc.close();
    }

    static long donuts(int N, int B, List<Integer>A){
        int lSum = 0;
        for (int i = 0; i < B; i++) {
            lSum += A.get(i);
        }
        int max = lSum;
        for (int rSum = 0,i = 0; i < B; ++i) {
            rSum += A.get(N-1-i);
            lSum -= A.get(B-1-i);
            max = Math.max(max,lSum+rSum);
        }
        return max;
    }
}

/*
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, lSum = 0;
        for(int i = 0; i < k; ++i){
            lSum += cardPoints[i];
        }
        int max = lSum;
        for(int rSum = 0, i = 0; i < k; ++i){
            rSum += cardPoints[n-1-i];
            lSum -= cardPoints[k-1-i];
            max = Math.max(max,lSum+rSum);
        }
        return max;
    }
}
 */

/*
Recursive + Memoization
    static long[][] dp;
    static long donuts(int N, int B, List<Integer>A){
        dp = new long[N+1][N+1];
        for (long [] arr : dp) Arrays.fill(arr,-1);
        return solve(B,A,0,A.size()-1);
    }

    private static long solve(int b, List<Integer> a, int start, int end) {
        if(b == 0) return 0;
        //if(start >= end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        return dp[start][end] = Math.max(
                solve(b-1,a,start+1,end) + a.get(start),
                solve(b-1,a,start,end-1) + a.get(end)
        );
    }
 */

/*
    //Prefix Sum passes all test cases
    static long donuts(int N, int B, List<Integer>A){
        int lSum = 0;
        for (int i = 0; i < B; i++) {
            lSum += A.get(i);
        }
        int max = lSum;
        for (int rSum = 0,i = 0; i < B; ++i) {
            rSum += A.get(N-1-i);
            lSum -= A.get(B-1-i);
            max = Math.max(max,lSum+rSum);
        }
        return max;
    }
 */