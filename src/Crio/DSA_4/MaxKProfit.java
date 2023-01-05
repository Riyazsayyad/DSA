package Crio.DSA_4;
import java.util.*;

public class MaxKProfit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        long res = maxKProfit(n, b, a);

        System.out.println(res);
    }

    static long maxKProfit(int N, int B, int[] a) {
        return 0L;
    }
}
