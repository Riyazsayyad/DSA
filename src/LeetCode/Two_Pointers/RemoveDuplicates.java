package LeetCode.Two_Pointers;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] in =  {1,2,3};
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

    public static int removeDuplicates(int[] nums) {
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

    }


}
