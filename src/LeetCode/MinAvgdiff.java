package LeetCode;
import java.util.*;
public class MinAvgdiff {
    public static int minAvgdiff(int[] arr){
        int n = arr.length,ans=0;
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        long minSum = Integer.MAX_VALUE;
        long sumP =0, sumS =0;
        for(int i=0;i<n;i++){
            sumP+=arr[i];
            prefix [i] = sumP;
        }
        for(int j=(n-1);j>-1;j--){
            sumS+=arr[j];
            suffix [j] = sumS;
        }
        int x = 1;
        for(int i=0;i<n;i++){
            long sum=0;
            if(x==n) sum = (prefix[i]/x);
            else sum = Math.abs((prefix[i]/x)-(suffix[x]/(n-x)));
            if(sum<minSum){
                minSum = sum;
                ans = i;
            }
            x++;
        }
        return ans;

    }


    public static void main(String[] args)
    {
        int [] arr = {2,5,3,9,5,3};
        System.out.println(minAvgdiff(arr));
    }
}
