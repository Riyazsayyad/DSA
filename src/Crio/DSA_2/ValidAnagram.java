package Crio.DSA_2;

import java.io.*;
import java.util.*;


public class ValidAnagram {
    public boolean validAnagram(String s, String t) {



        int[] arr = new int[256];
        for(char a: s.toCharArray())    arr[(int) a]++;
        for(char b: t.toCharArray())    arr[(int) b]++;

        for(int i =0;i<256;i++){
            if(arr[i]==1) return false;
        }
        return true;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String t = in.readLine();

        boolean result = new ValidAnagram().validAnagram(s, t);
        System.out.print(String.valueOf(result));
    }
}
