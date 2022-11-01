package Crio.DSA_2;

import java.util.*;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int a=0;
        int b=0;
        if(nums[0]>2)
            return 1;
        for(int i=0;i< nums.length;i++){
            if ((i+1)<nums.length) {
                if(nums[i]>=0) {
                    a = nums[i]+1;
                    b = nums[i + 1];
                    System.out.println(a+" "+b);
                    if(a==b) continue;
                    else return (a);
                }
            }
        }

        return b+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; ++i) {
            nums[i] = in.nextInt();
        }
        int result = new FirstMissingPositive().firstMissingPositive(nums);
        System.out.println(result);
    }
}
