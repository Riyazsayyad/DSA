package Crio.DSA_5.Dynamic_Programming;
import java.util.*;


class MaximumProductSubarray{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        Vector<Integer> vec = new Vector<Integer>();
        for(int i=0;i<n;i++)
            vec.add(sc.nextInt());
        System.out.println(maximumProductSubarray(vec));
    }

    private static long maximumProductSubarray(Vector<Integer> nums){
        int i;
        long ans = Integer.MIN_VALUE;
        long maxval = 1;
        long minval = 1;
        long prevMax;

        for (i = 0; i < nums.size(); i++) {

            if (nums.get(i) > 0) {
                maxval = maxval * nums.get(i);
                minval = Math.min(1, minval * nums.get(i));
            }

            else if (nums.get(i) == 0) {
                minval = 1;
                maxval = 0;
            }

            else if (nums.get(i) < 0) {
                prevMax = maxval;
                maxval = minval * nums.get(i);
                minval = prevMax * nums.get(i);
            }

            ans = Math.max(ans, maxval);

            if (maxval <= 0) {
                maxval = 1;
            }
        }

        return ans;
    }
}
