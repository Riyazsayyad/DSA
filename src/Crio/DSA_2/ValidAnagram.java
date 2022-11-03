package Crio.DSA_2;

import java.io.*;
import java.util.*;


public class ValidAnagram {
    public boolean validAnagram(String s, String t) {
        // this solution 99.19% faster than any other submission in leetcode 
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        for(char a: s.toCharArray())    arr1[(int) a]++;
        for(char b: t.toCharArray())    arr2[(int) b]++;
        if(Arrays.equals(arr1,arr2)) return true;
        else return false;

        /*
        // this approach only works for crio, and fails for aa bb input in Leetcode
        int[] arr = new int[256];
        for(char a: s.toCharArray())    arr[(int) a]++;
        for(char b: t.toCharArray())    arr[(int) b]++;

        for(int i =0;i<256;i++){
            if(arr[i]==1) return false;
        }
        return true;
        */

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String t = in.readLine();

        boolean result = new ValidAnagram().validAnagram(s, t);
        System.out.print(String.valueOf(result));
    }
}
