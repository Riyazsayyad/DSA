package Crio.DSA_5.Dynamic_Programming;
import java.util.*;
public class EditDistance {


    static int editDistance(String s1, String s2){
        //Space Complexity O(n+m)
        int n = s1.length(),m = s2.length();
        int[] prev = new int[(n>m?n:m)+1];
        int[] cur = new int[(n>m?n:m)+1];
        for (int i = 0; i <= n; i++) cur[i] = i;
        for (int i = 0; i <= m; i++) prev[i] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))    cur[j] = prev[j-1];
                else{
                    //1) insert 2) delete 3) replace
                    cur[j] = 1 + Math.min(cur[j-1],Math.min(prev[j],prev[i-1]));
                }
            }
            prev = cur;
        }
        return cur[m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int ans = editDistance(s1, s2);
        System.out.print(ans);
        sc.close();
    }
}

/*
Recursive + Memoization
    static int[][] dp;
    static int editDistance(String s1, String s2){
        dp = new int[s1.length()+1][s2.length()+1];
        for(int [] A: dp) Arrays.fill(A,-1);
        return solve(s1,s2,s1.length(),s2.length());
    }

    private static int solve(String s1, String s2, int i, int j) {
        if(j == 0)  return i; //del i chars
        if(i == 0)  return j; //insert j chars
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1))    return dp[i][j] = solve(s1,s2,i-1,j-1);
        else{
            //1) insert 2) delete 3) replace
            return dp[i][j] = 1 + Math.min(solve(s1,s2,i,j-1),Math.min(solve(s1,s2,i-1,j),solve(s1,s2,i-1,j-1)));
        }
    }
 */

/*
Space Complexity : O(n*m)
    static int editDistance(String s1, String s2){
        int n = s1.length(),m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int i = 0; i <= m; i++) dp[0][i] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))    dp[i][j] = dp[i-1][j-1];
                else{
                    //1) insert 2) delete 3) replace
                    dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];
    }
 */