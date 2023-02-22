package Crio.DSA_5.Dynamic_Programming;
import java.util.*;
public class MinimumJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }
        int ans = minimumJumps(n,a);
        System.out.println(ans);
        sc.close();
    }

    static int[] dp;
    static int ans;
    static boolean canReach;
    static int minimumJumps(int n,ArrayList<Integer> nums) {
        dp = new int[nums.size()+1];
        canReach = false;
        ans = Integer.MAX_VALUE;
        Arrays.fill(dp,Integer.MAX_VALUE);
        int res = solve(nums,0);
        return canReach ?  res : -1;
    }

    private static int solve(ArrayList<Integer> nums, int i) {
        if(i < nums.size() && nums.get(i) == 0) return -1;

        if(i >= nums.size() - 1){
            canReach = true;
            return 0;
        }
        if(dp[i] != Integer.MAX_VALUE) return dp[i];

        return dp[i] = Math.min(1+solve(nums,i + nums.get(i)),1+solve(nums,i + 1)); // go forwards
    }
}
