package Crio.DSA_5.Dynamic_Programming;

import java.io.*;
import java.util.*;
class DecodeWays {
    // Implement your Solution Here


    public int numDecodings(String s) {
        // 3) Dynamic Programming Approach
        int n = s.length(),ans,mod = (int) (1e9 + 7);
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);;
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            ans = 0;
            if(s.charAt(i-1) != '0')
                ans = dp[i-1]%mod;
            if(i > 1 && (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i - 1) <= '6')))
                ans = (ans%mod + dp[i-2]%mod)%mod;
            dp[i] = ans;
        }
        return dp[n];
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        int result = new DecodeWays().numDecodings(s);
        System.out.println(result);
    }
}

/*
1) The recursive method
    int ans;
    public int numDecodings(String s) {
        int n = s.length();
        ans = 0;
        getAns(s,n);
        return ans;

    }

    private int getAns(String s, int i) {
        if(i == 0) return 1;
        if(s.charAt(i-1) != '0')  ans = getAns(s,i-1);
        if(i > 1 && (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i - 1) <= '6'))) ans += getAns(s,i-2);
        return ans;
    }

 */
/*
2) recursive method with memoization
    int ans;
    int [] dp;
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[1000];
        Arrays.fill(dp,-1);;
        ans = 0;
        getAns(s,n);
        return ans;

    }

    private int getAns(String s, int i) {
        if(i == 0) return 1;
        if(dp[i] != -1) return dp[i];
        if(s.charAt(i-1) != '0')  ans = getAns(s,i-1);
        if(i > 1 && (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i - 1) <= '6'))) ans += getAns(s,i-2);
        return dp[i] = ans;
    }
 */

/*
3) Dynamic Programming Approach

 */