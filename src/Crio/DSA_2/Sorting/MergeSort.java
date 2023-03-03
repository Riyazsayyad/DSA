package Crio.DSA_2.Sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr){
        return  new int[0];
    }

    public static void main(String[] args){
        int[] a = {8,5,2,9,0,25,6,98,32};
        System.out.println(Arrays.toString(mergeSort(a)));
    }
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {

        if(start < end){
            int mid = start + (end - start)/2;

            sort(nums,start,mid);
            sort(nums,mid+1,end);

            merge(nums,start,mid,end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int n1 = mid - start + 1,n2 = end - mid;
        int L[] = new int[n1],R[] = new int[n2];

        System.arraycopy(nums,start,L,0,n1);
        System.arraycopy(nums,mid+1,R,0,n2);

        int i = 0, j = 0;

        int k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            }
            else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }
}
