package Crio.DSA_1;

import java.util.*;

public class NumberOfPrimesInRange {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l = 8;
        int r = 89;
        int ans = numberOfPrimesInARange(l, r);
        System.out.println(ans);
    }

    // TODO: Implement this method
    static int numberOfPrimesInARange(int l, int r) {
        int count=0;
        if (l<2)
            l=2;
        boolean[] sieve = new boolean[(r-l)+1];
        int[] nums = new int[sieve.length];
        int index=0;
        //filled array with true value
        java.util.Arrays.fill(sieve,true);

        // num array for calculations

        for(int i=l;i<=r;i++)
        {
            nums[index]=i;
            index++;
        }

        //for loop for marking not prime false
        int index1;
        for(int a=0;a*a<sieve.length;a++){
            if(sieve[a]==true)
            {
                index1=a+2;
                for(int i =index1*index1;i<=r;i+=index1)
                {
                   if(i>=l)
                   {
                       sieve[i - l] = false;
                       //System.out.println((i) + " " + a +" "+index1);
                   }


                }
            }
        }
        for(int i=0;i<sieve.length;i++)
            if(sieve[i]==true)
                count++;


        return count;
    }
}
