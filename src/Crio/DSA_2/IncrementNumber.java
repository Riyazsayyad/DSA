package Crio.DSA_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IncrementNumber {
    public static void main(String args[]){

        int n = 2;
        int arr[] = {9,9};

        int incArr[] = incrementNumber(n, arr);

        for(int i=0;i<incArr.length;i++) {
            System.out.print(incArr[i]);
        }

    }

    static int[] incrementNumber(int n, int arr[]){
        int carry=0;
        int sum=0;
        int dec=0;
        int [] cp;

        for(int i=n-1;i>=0;i--) {
            if(i==(n-1))
                sum = arr[i]+1;
            else sum = arr[i] +carry;
            dec = (sum % 10) ;
            carry = sum / 10;
            arr[i]=dec % 10;
        }
        if(carry!=0)
            arr=Arrays.copyOf(arr,arr.length+1);
            arr[0]+=carry;
        return arr;
        }
    }

