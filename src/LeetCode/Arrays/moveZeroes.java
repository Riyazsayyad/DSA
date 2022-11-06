package LeetCode.Arrays;

import java.util.Arrays;

public class moveZeroes {
    public static void moveZeroes(int[] nums) {
        int j =0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }else continue;
        }
        for(int a = j;a<nums.length;a++){ nums[a]=0;}
        System.out.println(Arrays.toString(nums));

        /*
        // O(n^2)
        for(int i=0;i<(nums.length-1);i++){
            int j = i+1;
            if(nums[i]==0){
                while(nums[j] == 0 && j<nums.length-1){ j++;}
                nums[i]=nums[j];
                nums[j]=0;
                System.out.println(Arrays.toString(nums));
            }
        }
        */
    }
    public static void main(String[] args){
        int [] nums ={0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
