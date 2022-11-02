package Crio.DSA_2;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.*;
import java.lang.Math;
class  PermutationPalindrome {

    public  static int isPermutationPalindrome(String s ) {
        int [] arr = new int[256];
        for(char c:s.toCharArray()){
            arr[(int)c]++;
        }

        int odd=0;
        for(int i=0;i<256;i++){
            if(arr[i]%2==1)
                odd++;
            if(odd > 1)
                return 0;
        }
        return 1;
    }
    public static void  main (String args []) {

        Scanner sc =  new  Scanner (System.in);
        int t = 1;
        t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            t--;
            String s = new String();
            s = sc.next();

            int flag = isPermutationPalindrome(s);
            if (flag == 1) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

}