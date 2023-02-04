package Crio.DSA_1.Simple_Math;

import java.util.*;
import java.lang.*;
import java.io.*;

class DecimalToBaseConversion {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        //17075 13
        Scanner sc = new Scanner(System.in);
        int n = 17075;
        int b = 13;

        String result = decimalToBaseConversion(n, b);
        System.out.println(result);

    }

    // TODO: Implement this method
    static String decimalToBaseConversion(int n, int b) {
        StringBuilder sum1 = new StringBuilder();
        String sum="";
        String [] alpha ={"A","B","C","D","E","F"};
        while(n!=0){
            if(n%b>=10)
            {
                sum+=alpha[(n%b)-10];
            }
            else
            {
                sum+=n%b;
            }
            n=n/b;
        }
        sum1.append(sum);
        sum1.reverse();
        return String.valueOf(sum1);
    }
}