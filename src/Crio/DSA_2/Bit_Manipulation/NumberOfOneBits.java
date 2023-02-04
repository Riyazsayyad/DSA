package Crio.DSA_2.Bit_Manipulation;

import java.util.*;


class NumberOfOneBits{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int ans = numberOfOneBits(n);
        System.out.print(ans);
    }

    static int numberOfOneBits(long n){
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0) ++count;
        }
        return count;
    }
}
