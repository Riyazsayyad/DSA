package Crio.DSA_2.Two_Pointers;
import java.util.*;

public class MaxSumTriplet {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            long arr[] = new long[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextLong();

            long result = maxSumTriplet(n, arr);

            System.out.println(result);

        }

    }

    static long maxSumTriplet(int n, long arr[]) {
        long res = 0;
        for(int i=1;i<n-1;i++){
            long maxL =0;
            long maxR =0;
            //max check for left
            for(int l=0;l<i;l++){
                if(arr[i]>arr[l])   maxL = Math.max(maxL,arr[l]);
            }
            //max check for right
            for(int r=i+1;r<n;r++){
                if(arr[r]>arr[i])   maxR = Math.max(maxR,arr[r]);
            }
            if(maxL>0 && maxR>0)    res = Math.max((maxL+maxR+arr[i]),res);

        }
        return res;
    }
}
