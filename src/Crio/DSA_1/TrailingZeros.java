package Crio.DSA_1;
import java.util.*;
public class TrailingZeros {
    // TODO: Implement this method
    static long findTrailingZeros(long n) {
        if(n<0)
            return -1;
        long count =0L;
        for(long i=5;(n/i)>=1;i*=5){
            count+=n/i;
            System.out.println("N : "+(n/i)+" Count: "+count+" I: "+i);
        }
        return count;
    }
    //482977237780772
    // NOTE: Please do not modify this function
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = 1931908951123131L;
        System.out.println(findTrailingZeros(n));
    }
}
