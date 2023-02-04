package Crio.DSA_2.Sorting;
import java.util.*;

public class SortArrayAbsolute {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int res[] = sortArrayAbsolute(n, arr);

        for (int j : res)
            System.out.print(j + " ");
    }

    static int[] sortArrayAbsolute(int n, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int a:arr)  list.add(a);
        Collections.sort(list,AbsCompare);
        for (int i = 0; i < n; i++) arr[i]=list.get(i);
        return arr;
    }

    public static Comparator<Integer> AbsCompare = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            if (Math.abs(a) < Math.abs(b)) return -1;
            else if (Math.abs(a) > Math.abs(b)) return 1;
            else return 0;
        }
    };
}

