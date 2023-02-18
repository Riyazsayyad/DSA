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

    static long[][] dp;
    static long donuts(int N, int B, List<Integer>A){
        dp = new long[N+1][N+1];
        for (long [] arr : dp) Arrays.fill(arr,-1);
        return solve(B,A,0,A.size()-1);
    }

    private static long solve(int b, List<Integer> a, int start, int end) {
        if(b == 0) return 0;
        if(start >= end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        return dp[start][end] = Math.max(
                solve(b-1,a,start+1,end) + a.get(start),
                solve(b-1,a,start,end-1) + a.get(end)
        );
    }
}

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
        if(start >= end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        return dp[start][end] = Math.max(
          solve(b-1,a,start+1,end) + a.get(start),
                solve(b-1,a,start,end-1) + a.get(end)
        );
    }
 */