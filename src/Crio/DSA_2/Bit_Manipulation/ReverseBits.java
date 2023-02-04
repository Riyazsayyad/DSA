package Crio.DSA_2.Bit_Manipulation;
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
            long temp = (n & (1<<i));
            if(temp != 0L){
                res |= (1<<(31-i));
            }
        }
        return res;
    }
}
