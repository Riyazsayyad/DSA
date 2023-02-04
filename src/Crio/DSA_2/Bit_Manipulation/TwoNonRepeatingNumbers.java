package Crio.DSA_2.Bit_Manipulation;

import java.util.*;

class TwoNonRepeatingNumbers{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int ans[] = twoNonRepeatingNumbers(nums);
        System.out.println(ans[0]+" "+ans[1]);
        sc.close();
    }

    static int[] twoNonRepeatingNumbers(int[] nums) {
        int xor = 0;
        var ans = new int[2];
        for (int num : nums)    xor ^= num;
        int mask = xor & -xor;
        for(int num : nums){
            if((num & mask)==0) ans[1] ^= num;
            else ans[0] ^= num;
        }
        Arrays.sort(ans);
        return ans;
    }
}