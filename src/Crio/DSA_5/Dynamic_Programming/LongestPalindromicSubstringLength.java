package Crio.DSA_5.Dynamic_Programming;

import java.util.*;
public class LongestPalindromicSubstringLength
{
    static int longestPalindromicSubstringLength(String str) {
        int ans = 1,n = str.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
            if(i + 1 < n && str.charAt(i) == str.charAt(i+1)){
                dp[i][i+1] = true;
                ans = 2;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i+len-1 < n; i++) {
                int j = i + len - 1;
                if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    ans = len;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for(int tests=0;tests<t;tests++)
        {
            int n= sc.nextInt();
            String s= sc.next();
            System.out.println(longestPalindromicSubstringLength(s));
        }
    }
}
