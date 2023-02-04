package Crio.DSA_2.Sorting;
import java.util.*;
public class CountSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        String res = countSort(n, s);

        System.out.println(res);

    }

    static String countSort(int n, String s) {
        int max = 0,sum =0;
        char[] arr = s.toCharArray();
        for(char a: arr)    max= Math.max(max, a);
        int[] countArr = new int[(max-97)+1];
        int[] posArr = new int[(max-97)+1];
        char[] ans = new char[n];
        for(char a: arr)    countArr[(int)a-97]++;
        for (int i = 0; i < countArr.length; i++){
            sum+=countArr[i];
            posArr[i] = sum;
        }
        for (int j = n-1; j >=0 ; j--) {
            posArr[(int)arr[j]-97]--;
            ans[posArr[(int)arr[j]-97]]=arr[j];
        }
        return String.valueOf(ans);
    }
}
