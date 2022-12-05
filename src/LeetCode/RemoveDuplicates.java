package LeetCode;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] in = {1,2,3};
        /*
        {1,1,1}
        {1,1,2}
        {0,0,1,1,1,2,2,3,3,4}
        {1,1}
        {1,2}
        {1,2,3}
         */
        int x = removeDuplicates( in );
        System.out.println(x);
    }
    // jaise hi duplicate dikha while shuru khtm hote hi count pr element
    // {0,0,1,1,1,2,2,3,3,4}
    public static int removeDuplicates(int[] nums) {
        int count =0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                while (nums[i-1]==nums[i] && i<nums.length-1) { i++;}
            }
            nums[++count]=nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return count;
        /*
        int a = 0 ;
        int b = 1 ;
        int n = nums.length ;
        int i = 0 ;

        int [] ans = new int[n];
        if(n==1)
            return 1;
        else if(n==2)
            if(nums[0]!=nums[1])
                return 2;

        while(b<n){
            if(nums[a]==nums[b]) {
                ans[i] = nums[a];
            }
            else if(nums[a]!=nums[b]){
                ans[i] = nums[a];
                if(b==(n-1))
                    ans[i+1] = nums[n-1];

                a=b;
                i++;

            }
            else if(b==(n-1)){
                ans[i+1] = nums[n-1];
                i++;
            }

            b++;
        }
        for(int j =0;j<n;j++)
            nums[j]=ans[j];
        //System.out.println(Arrays.toString(nums));
        return ++i;
*/
    }


}
