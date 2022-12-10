package Crio.DSA_2;

import java.util.*;

class Conversion{
    public static int conversion(long A,long B)
    {
        long xor = A ^ B;
        int count = 0;
        while (xor != 0){
            ++count;
            xor=xor&(xor-1);
        }
        return count;
    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        System.out.println(conversion(a,b));
    }
}
