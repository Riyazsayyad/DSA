package LeetCode.Sorting;

import java.util.*;
public class WiggleSort {
    public static void main(String args[]){
        int[] nums={1,4,6,7,3,9,2,5};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

    public static void wiggleSort(int[] nums) {
        int i=0,n= nums.length;
        while (i<n){
            if(i+1<n && nums[i]<nums[i+1]) swap(i,i+1,nums);
            if(i-1>=0 && nums[i]<nums[i-1]) swap(i,i-1,nums);
            i+=2;
        }
    }
}
