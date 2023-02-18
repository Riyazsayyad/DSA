package Crio.DSA_5.Dynamic_Programming;
import java.io.*;
import java.util.*;
class FindPersonWithHeightH {

    // Complete the function implementation below
    public int findPersonWithHeightH(int[] seq, int H) {
        int index = Arrays.binarySearch(seq,H);
        return  (index >= 0) ? index : -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int seq[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            seq[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        while(q > 0) {
            int H = scanner.nextInt();
            int result = new FindPersonWithHeightH().findPersonWithHeightH(seq , H);
            System.out.println(result);
            q--;
        }
    }
}
