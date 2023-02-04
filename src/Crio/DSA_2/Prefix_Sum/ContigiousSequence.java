package Crio.DSA_2.Prefix_Sum;

import java.io.*;
import java.util.Scanner;

public class ContigiousSequence {
    public static  long contigiousSequence(int arr[] , int n) {
        // Kadanes algorithm
        long cs=0,ms=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            cs+=arr[i];
            if(cs>ms)    ms=cs;
            if(cs<0)    cs=0;
        }
        return ms;
    }
    public static void  main (String args []) {

        Scanner sc =  new  Scanner (System.in);

        int n = sc.nextInt();
        int arr [] = new int[n];
        for ( int i = 0 ; i < n; i++)
            arr[i] = sc.nextInt();

        long max = contigiousSequence(arr, n);
        System.out.println(max);

    }
}
