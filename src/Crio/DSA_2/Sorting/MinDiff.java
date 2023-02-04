package Crio.DSA_2.Sorting;
import java.util.*;
public class MinDiff {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = minDiff(n, a);

        System.out.println(res);

    }



    static int minDiff(int n, int a[]) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) min = Math.min(a[i]-a[i-1],min);
        return min;
    }
}
