package Crio.DSA_2;
import java.util.*;
public class CountOccurrences {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int res = countOccurrences(n, k, a);

        System.out.println(res);
    }

    static int countOccurrences(int n, int k, int a[]) {
        int start = 0,end = n-1,lastJ = 0,count = 0,firstI=Integer.MAX_VALUE;
        /*
        -1 2 2 4 7
        finding the last index then traversing back to find count: worst case O(n)
         */
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if(a[mid]==k)   lastI = Math.max(lastI,mid);
//
//            if(a[mid]<=k)    start=mid+1;
//            else end = mid-1;
//        }
//        while (a[lastJ]==k){
//            ++count;    --lastJ;
//            if(lastI==-1) break;
//        }
//        return count;
        /*
        Solving using finding last and first index then subtracting it to find count : Worst case O(logN)
         */
        while (start <= end) { // to find last index
            int mid = (start + end) / 2;
            if(a[mid]==k)   lastJ = Math.max(lastJ,mid);

            if(a[mid]<=k)    start=mid+1;
            else end = mid-1;
        }
        start=0;
        end=lastJ;
        while (start <= end) { // to find first index
            int mid = (start + end) / 2;
            if(a[mid] == k)   firstI = Math.min(mid,firstI);

            if(a[mid]<k)    start=mid+1;
            else end=mid-1;


        }
        //System.out.println(lastJ+" "+firstI);
        if((lastJ-firstI+1)<0)  return 0;
        return (lastJ-firstI)+1;
    }
}
