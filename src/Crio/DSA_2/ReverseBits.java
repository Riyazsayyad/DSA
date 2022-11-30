package Crio.DSA_2;
import java.util.*;
public class ReverseBits {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while(t-->0){
            long n = sc.nextLong();
            long ans = reverseBits(n);
            System.out.println(ans);
        }
    }

    static long reverseBits(long n){
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }
        return res;
    }
}
