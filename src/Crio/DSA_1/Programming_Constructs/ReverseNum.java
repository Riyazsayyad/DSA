package Crio.DSA_1.Programming_Constructs;

import java.util.*;

class ReverseNum {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int reverse = reverseNum(num);



        System.out.println(reverse);

    }

    // TODO: Implement this method
    static int reverseNum(int num) {

        int  lastdigit=0;
        int rev =0;

        while(num>0){
            lastdigit = num % 10;
            rev = (rev * 10 )+lastdigit;
            num = num/10;
        }
        return rev;
    }
}
