package Crio.DSA_2.Bit_Manipulation;

import java.util.*;

public class SwapAllOddAndEvenBits {
    // Complete the function below
    public long swapBits(long n) {
        long evenBits = n & 0xAAAAAAAA;
        long oddBits = n & 0x55555555;
        evenBits >>= 1;
        oddBits <<= 1;
        return evenBits | oddBits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        long result = new SwapAllOddAndEvenBits().swapBits(n);
        System.out.println(result);
    }
}
