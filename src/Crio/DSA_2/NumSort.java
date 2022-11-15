package Crio.DSA_2;
import java.util.*;
public class NumSort {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String arr[] = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        String sortedArray[] = numSort(n, arr);

        for (String num : sortedArray) {
            System.out.print(num + " ");
        }

    }

    static String[] numSort(int n, String[] arr) {
        Arrays.sort(arr,NumCompare);
        return arr;
    }
    public static Comparator<String> NumCompare = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            if (a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        }
    };
}
