package Crio.DSA_2;
import java.util.*;
public class EqualPartition {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long arr[] = new long[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        int res = equalPartition(n, arr);

        System.out.println(res);

    }

    static int equalPartition(int n, long arr[]) {
        long sum=0,cs=0;
        for(long a: arr){
            sum+=a;
        }
        for(int i=0;i<arr.length;i++){
            if(cs == (sum-cs-arr[i])) return i;
            else    cs+=arr[i];
        }
        return -1;
    }
}
