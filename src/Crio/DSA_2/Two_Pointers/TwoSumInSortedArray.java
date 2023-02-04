package Crio.DSA_2.Two_Pointers;
import java.util.*;

public class TwoSumInSortedArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        boolean res = twoSumInSortedArray(n, arr, k);

        String ans = (res) ? "Present" : "Not Present";

        System.out.println(ans);

    }

    static boolean twoSumInSortedArray(int n, int arr[], int k) {
        int i =0;
        int j =n-1;
        while (j>i){
            int sum = arr[j] + arr[i];
            if(sum>k)   j--;
            else if(sum == k)   return true;
            else    i++;
        }
        return false;
    }
}
