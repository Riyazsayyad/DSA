package Crio.DSA_3;

import java.util.*;

class LongestPalindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        int res = longestPalindrome(n, s);

        System.out.println(res);
    }

    static int longestPalindrome(int n, String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char chr : s.toCharArray())   map.put(chr,map.getOrDefault(chr,0)+1);
        ArrayList<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        int even = 0, odd = 0;
        for(Map.Entry<Character, Integer> ele : list ){
            int val = ele.getValue();
            even += (val/2)*2;
            odd |= val%2; // else we can declare boolean flag if odd detected it will add one to even and return
        }
        return odd+even;
    }
}