package Crio.DSA_2.Two_Pointers;

import java.io.*;
import java.util.*;

public class MergeSortedArray {
    // Implement your solution by completing the below function
    public static int [] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m+n];
        int i=0;
        int j=0;
        int count =0;
        while(i<m && j<n){
            if(nums1[i]>nums2[j]){   ans[count] = nums2[j]; ++count; j++;}
            else if(nums1[i]<nums2[j]){   ans[count] = nums1[i]; ++count; i++;}
            else {   ans[count] = nums1[i]; ++count; i++;}
        }
        while (i<m){
            ans[count] = nums1[i];
            i++;
            ++count;
        }
        while (j<n){
            ans[count] = nums2[j];
            j++;
            ++count;
        }

        return ans;
        /*
        //slow approach
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();
        int x = m+n;
        int [] ans = new int[x];
        for(int a: nums1)   pQ.add(a);
        for(int b: nums2)   pQ.add(b);
        for(int i=0;i<x;i++)    ans[i]=pQ.poll();
        return ans;
        */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];

        for (int i = 0; i < m; i++)
            nums1[i] = scanner.nextInt();
        for (int i = 0; i < n; i++)
            nums2[i] = scanner.nextInt();

        scanner.close();

        int[] nums = mergeSortedArray(nums1, m, nums2, n);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
