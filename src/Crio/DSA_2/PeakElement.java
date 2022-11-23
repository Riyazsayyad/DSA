package Crio.DSA_2;
import java.util.*;
public class PeakElement {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(peakElement(arr));
    }
    static int peakElement(int arr[]){
        int n= arr.length, start =0, end =n-1;
        if(arr[start]<arr[end]) return 0;
        while (start<=end){
            int mid = (start+end)/2;
            int prev = (mid+n-1)%n, next = (mid+1)%n;
            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]){    return mid;}

            if(arr[mid] <= arr[end]){ end= mid-1;}
            else if(arr[mid] >= arr[start]) {start= mid+1;}
        }
        return -1;
    }
}
