package LeetCode;

import java.util.*;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        Long[] A = new Long[nums.length];
        for (int i = 0; i < nums.length; i++) A[i] = (long) nums[i];
        Arrays.parallelSort(A,(a,b) -> (int)
                (Long.parseLong(b.toString().concat(a.toString())) -
                        Long.parseLong(a.toString().concat(b.toString()))));
        StringBuilder ans = new StringBuilder();
        for (Long X: A) ans.append(X);
        return ans.toString().charAt(0) == '0' ? "0" :ans.toString();
    }
}
