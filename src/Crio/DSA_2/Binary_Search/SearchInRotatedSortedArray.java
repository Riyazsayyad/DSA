package Crio.DSA_2.Binary_Search;
import java.util.*;
public class SearchInRotatedSortedArray {
    // Complete the function implementation below
    public int findPivot(int[] nums){
        int n= nums.length,start =0, end =n-1;
        if(nums[start]<nums[end]) return 0;
        while (start<=end){
            int mid = (start+end)/2;
            int prev = (mid+n-1)%n, next = (mid+1)%n;
            if(nums[mid]<=nums[next] && nums[mid]<=nums[prev]){    return mid;}

            if(nums[mid] <= nums[end]){ end= mid-1;}
            else if(nums[mid] >= nums[start]) {start= mid+1;}
        }
        return -1;
    }
    public int binarySearch(int[] nums,int pivot,int target,int limit){
        int start = pivot, end = limit;
        while (start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target) return mid;

            if(nums[mid]<target) start=mid+1;
            else  end = mid-1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int n = nums.length;
        int low = 0;
        int high = n-1;

        if(nums[low]<nums[high]) return binarySearch(nums,low,target,high);

        if(target<=nums[(pivot-1)%n] && target>=nums[low]) return binarySearch(nums,low,target,pivot);
        else if (target>=nums[pivot] && target<=nums[high])return binarySearch(nums,pivot,target,high);
        else return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        while(q > 0) {
            int target = scanner.nextInt();
            int result = new SearchInRotatedSortedArray().search(nums , target);
            System.out.println(result);
            q--;
        }
    }
}
