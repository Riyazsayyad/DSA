package Striver_SDE_Sheet.Day_1;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        StringBuilder num = new StringBuilder();
        for (int a : nums) num.append(a);

        String ans = getNextGreaterPermutation(new StringBuilder(num),num,0,num.length());

        if(ans == null){
            int start = 0,end = nums.length-1;
            while (start++ <= end--){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }else{
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Character.getNumericValue(ans.charAt(i));
            }
        }

    }

    private String getNextGreaterPermutation(StringBuilder orgString,StringBuilder num,int l,int r) {
        if(l == r && Integer.parseInt(orgString.toString()) < Integer.parseInt(num.toString()) ) return num.toString();

        for (int i = l; i < num.length(); i++) {
            swap(num, l, i);
            String nextGreater = getNextGreaterPermutation(orgString,num, l + 1, r);
            if (nextGreater != null) return nextGreater;
            swap(num, l, i);
        }
        return null;
    }

    private static void swap(StringBuilder num, int i, int j) {
        char temp = num.charAt(i);
        num.setCharAt(i, num.charAt(j));
        num.setCharAt(j, temp);
    }
}
