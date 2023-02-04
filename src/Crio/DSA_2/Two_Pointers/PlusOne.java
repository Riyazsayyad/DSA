package Crio.DSA_2.Two_Pointers;
import java.io.*;
import java.util.*;
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length-1,carry=0,sum=0,n1 = digits.length;
        if(digits[n]<9)digits[n]++ ;
        else{
            digits[n] =0;
            carry =1;
            while(n!=0 ){
                sum=(digits[n-1]+carry);
                carry = sum/10;
                digits[n-1]=sum%10;
                n--;
            }
            if(carry!=0){
                digits= Arrays.copyOf(digits,n1+1);
                digits[0]=carry;
            }
        }
        return digits;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int[] digits = new int[input.length];
        for (int i = 0; i < input.length; ++i) {
            digits[i] = Integer.parseInt(input[i]);
        }

        int[] result = new PlusOne().plusOne(digits);
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
            if (i != result.length - 1)
                System.out.print(" ");
        }
    }
}
