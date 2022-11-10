package LeetCode.Arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.*;


public class SubarraySum {
    public static int  subarraySum(int[] nums, int k) {
        int sum=0,count=0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1); // if sum - k is 0,(i.e, sum==k(2==2))
        for(int i : nums){
            sum+=i; //for prefix
            count+=preSum.getOrDefault(sum-k,0); // to get count of sum-k if not available add 0
            preSum.put(sum,preSum.getOrDefault(sum,0)+1); // to put sum in hashmap and add count if :
                                                                            // sum is already present add 1 to present sum or add 1
        }
        return count;
    }
    public static void main(String[] args) {
            int k =3;
            int[] res={1,2,1,2,1};
            System.out.println(subarraySum(res,k));

    }
}
