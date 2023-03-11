package Striver_SDE_Sheet.Day_1;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length,k,l;

        //break point decreasing sequence
        for(k = n - 2;k >= 0;k--){
            if(nums[k] < nums[k+1]) break;
        }

        //if the whole array is in decreasing sequence
        if(k < 0) reverse(nums,0,n-1);
        else{
            //break point of increasing sequence
            for(l = n - 1;l > k;l--){
                if(nums[l] > nums[k]) break;
            }
            swap(nums,k,l);
            reverse(nums,k+1,n-1);
        }
    }

    void swap(int[] A,int k, int l) {
        int temp = A[k];
        A[k] = A[l];
        A[l] = temp;
    }

    void reverse(int[] A,int l,int r){
        while(l<r){
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++; r--;
        }
    }
}
