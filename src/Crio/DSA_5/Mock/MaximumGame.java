package Crio.DSA_5.Mock;
import java.util.*;


class MaximumGame{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maximumGame(nums,n));
    }


    static int maximumGame(int[] nums,int n){
        int[][] dp = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i-1];
        }
        return Math.max(dp[n][0],dp[n][1]);
    }

}
