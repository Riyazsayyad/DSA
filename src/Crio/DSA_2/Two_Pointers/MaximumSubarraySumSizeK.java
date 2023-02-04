package Crio.DSA_2.Two_Pointers;

import java.util.*;
public class MaximumSubarraySumSizeK {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maximumSubarraySumSizeK(arr, n, k));
        sc.close();
    }

    static int maximumSubarraySumSizeK(int[] arr, int n, int k) {
        int [] prefixArr = new int[n+1];
        int sum=0, high =k, low= 1, prevsum=0, maxsum= Integer.MIN_VALUE; // min value to catch edge case if the array is of negative elements
        for(int i=0;i<n;i++){
            sum+=arr[i];
            prefixArr[i+1] = sum; // maintaining prefix sum array with 1 based indexing
            }
        // Sliding window
        while (high<n+1){
            maxsum = Math.max(prefixArr[high]-prevsum,maxsum);
            prevsum = prefixArr[low];
            low++; high++;
        }
        return maxsum;
    }
}
