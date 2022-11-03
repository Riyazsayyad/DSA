package LeetCode.Arrays;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int n =numbers.length;
        int i =0;
        int j =n-1;
        int[] ans = new int[2];
        while (j>i){
            int sum = numbers[j] + numbers[i];
            if(sum>target)   j--;
            else if(sum == target){ ans[0]=++i; ans[1]=++j; return ans; }
            else    i++;
        }
        return ans;
    }
}
