package Crio.DSA_2;

import java.io.*;
import java.util.*;

public class SwapAllOddAndEvenBits {
    // Complete the function below
    public long swapBits(long n) {
        return n&(n<<1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        long result = new SwapAllOddAndEvenBits().swapBits(n);
        System.out.println(result);
    }
}
