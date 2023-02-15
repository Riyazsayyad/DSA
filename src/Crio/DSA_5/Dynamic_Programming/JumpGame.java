package Crio.DSA_5.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

class JumpGame {
    // Implement Your Solution Here
    //5 1 2 3 T
    //1 0 5 4 F

    public String canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(max < i) return "false"; //agr aage badhne k jumps na ho 3, 2, 1, 0, 4
            max = Math.max(max,i + nums[i]);
            if(max >= nums.length - 1) return "true";
            if(nums[i] == 0 && max == i) return "false"; //jaa bhi yha tak skte the
        }
        return "true";
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ;i++) {
            nums[i] = scanner.nextInt();
        }
        String result = new JumpGame().canJump(nums);
        System.out.println(result);
        scanner.close();
    }
}

/*
// Bottom Up DP Approach
        boolean[] dp = new boolean[1000000];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[nums.length-1] ? "true" : "false";
 */
/*
// Top Down Recursive + Memoization Approach
    static int[] dp;
    public String canJump(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums,0) ? "true" : "false";
    }

    static boolean ans;
    private boolean solve(int[] nums, int i) {
        if(i < nums.length && nums[i] == 0) return false;
        if(i >= nums.length - 1) return true;
        if(dp[i] != -1) return dp[i] != 0;

        ans = solve(nums,i + nums[i]) || ans; // go forwards
        dp[i] = ans ? 1 : 0;

        return ans;
    }
 */