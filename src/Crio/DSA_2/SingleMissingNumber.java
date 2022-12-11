package Crio.DSA_2;

import java.util.*;


class SingleMissingNumber{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(singleMissingNumber(nums, n));
        sc.close();
    }

    static int singleMissingNumber(int[] nums, int n){
        int xor =0;
        Arrays.sort(nums);
        for (int x : nums){
            if((xor ^ x) != 0) return xor;
            xor++;
        }
        return xor;
        /*
        Arrays.sort(nums);
        var cnt = 0;
        for (int i = nums[0]; i <= nums[n-1]; i++) {
            if(nums[cnt++] != i) return i;
        }
        if (Arrays.binarySearch(nums,n) < -1) return n;
        return 0;
        */
    }
}
