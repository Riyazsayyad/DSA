package Crio.DSA_5.Dynamic_Programming;
import java.util.*;

class TargetSum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(targetSum(nums,target));
        sc.close();
    }


    static int targetSum(int[] nums,int target){
        int[][] dp = new int[nums.length+1][target+1];
        for (int i = 0; i <= nums.length; i++) dp[i][1] = 1;


        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[dp[i][j] + nums[i]][j] + dp[dp[i][j] - nums[i]][j];
            }
            if (dp[i][target] == target) ans++;
        }

        return ans;
    }

//    private static int solve(int[] nums, int target, int sum,int i) {
//        if(sum == target && i == nums.length) ans++;
//        if(i < nums.length)
//            sum = solve(nums,target,sum + nums[i],i+1)
//                    + solve(nums,target,sum - nums[i],i+1);
//        return ans;
//    }
}

/*
Recursive Approach
    static int ans;
    static int[] dp;
    static int targetSum(int[] nums,int target){
        ans = 0;
        dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums,target,0,0);
    }

    private static int solve(int[] nums, int target, int sum,int i) {
        if(sum == target && i == nums.length) ans++;
        if(i < nums.length) sum = solve(nums,target,sum + nums[i],i+1) + solve(nums,target,sum - nums[i],i+1);
        return ans;
    }
 */