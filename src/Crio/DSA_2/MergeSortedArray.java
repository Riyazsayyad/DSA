package Crio.DSA_2;

import java.io.*;
import java.util.*;

public class MergeSortedArray {
    // Implement your solution by completing the below function
    public static int [] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        //slow approach
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();
        int x = m+n;
        int [] ans = new int[x];
        for(int a: nums1) pQ.add(a);
        for(int b: nums2) pQ.add(b);
        for(int i=0;i<x;i++){
            ans[i]=pQ.poll();
        }
        return ans;
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
