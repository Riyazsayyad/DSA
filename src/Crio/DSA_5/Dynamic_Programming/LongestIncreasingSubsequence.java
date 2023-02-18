package Crio.DSA_5.Dynamic_Programming;
import java.util.*;


class LongestIncreasingSubsequence{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        Vector<Integer> vec = new Vector<Integer>();
        for(int i=0;i<n;i++)
            vec.add(sc.nextInt());
        System.out.println(longestIncreasingSubsequence(vec));
    }

    static int result;
    static int[] dp;
    private static int longestIncreasingSubsequence(Vector<Integer> vec){
        int n = vec.size();
        if(vec.isEmpty()) return 0;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        result = 1;
        solve(n,vec);
        return result;
    }

    private static int solve(int n, Vector<Integer> vec) {
        if(n == 1) return 1;
        int res,maxOfSequence = 1;
        if(dp[n-1] != -1) return dp[n-1];

        for (int i = 1; i < n; i++) {
            res = solve(i,vec);
            if(vec.get(i-1) < vec.get(n - 1) && res + 1 > maxOfSequence) maxOfSequence = res + 1;
        }

        result = Math.max(result,maxOfSequence);
        return dp[n-1] = maxOfSequence;
    }
}

/*
Wrong:
        int[] dp = new int[1000];
        int mod = 50000;
        int ans = 0;
        for (int i = 1; i <= vec.size(); i++) {
            if(vec.get(i-1) != 0){
                dp[vec.get(i-1) % mod] = 1 + dp[vec.get(i-1)-1 % mod];
                ans = Math.max(dp[vec.get(i-1) % mod],ans);
            }
        }
        return ans;
 */