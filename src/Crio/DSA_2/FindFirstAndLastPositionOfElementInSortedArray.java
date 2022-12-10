package Crio.DSA_2;
import java.util.*;
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] findFirstAndLastPositionOfElementInSortedArray(int[] nums, int target) {
        int[] ans = {-1, -1};
        int  start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) start = mid + 1; // this help in finding last occurrence as it goes forward (start = mid + 1)
            else end = mid - 1;
            if (nums[mid] == target) ans[1] = mid;
        }
        start = 0; end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) end = mid - 1;  // this help in finding first occurrence as it goes backward (end = mid - 1)
            else start = mid + 1;
            if (nums[mid] == target) ans[0] = mid;
        }
        return ans;
    }
}