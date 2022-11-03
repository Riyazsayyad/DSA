package Crio.DSA_2;

import java.util.*;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int [] sieve = new int[n+1];
        for(int i=0;i<n;i++){
            if(nums[i]>0 && nums[i]<=n){
                sieve[nums[i]]=1;
            }
        }
        for(int j=1;j<sieve.length;j++){
            if(sieve[j]==0){
                return j;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; ++i) {
            nums[i] = in.nextInt();
        }
        int result = new FirstMissingPositive().firstMissingPositive(nums);
        System.out.println(result);
    }
}
