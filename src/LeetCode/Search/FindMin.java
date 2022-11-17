package LeetCode.Search;

public class FindMin {
    public int findMin(int[] nums) {
        int next, prev, n = nums.length;
        int start =0, end = n-1;
        while(start<=end){
            int mid = (start+end)/2;
            next = (mid+1)%n; prev = (mid +n-1)%n;

            if(nums[mid]<= nums[next] && nums[mid]<= nums[prev]){    return nums[mid];}
            if(nums[mid] <= nums[end]){ end= mid-1;}
            else if(nums[mid] >= nums[start]) {start= mid+1;}
        }
        return -1;
    }
}
