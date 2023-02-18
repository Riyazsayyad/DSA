package Crio.DSA_5.Dynamic_Programming;
import java.util.*;

class LongestCommonSubstring{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(longestCommonSubstring(s1,s2));
            t--;
        }
        sc.close();
    }

    static int longestCommonSubstring(String s1, String s2){
        int n = s1.length(),m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                ans = Math.max(ans,dp[i][j]);
            }
        }

        return ans;
    }
}
