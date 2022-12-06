package Crio.DSA_3;

import java.util.*;

class SimilarString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            String first_string = sc.next();
            String second_string = sc.next();
            String answer = similarString(n, m, first_string, second_string, k);
            System.out.println(answer);
        }
        sc.close();
    }

    static String similarString(int n, int m, String s, String t, int k) {
        HashMap<Character,Integer> word1 = new HashMap<>();
        HashMap<Character,Integer> word2 = new HashMap<>();
        for(char c1 : s.toCharArray())  word1.put(c1,word1.getOrDefault(c1,0)+1);
        for(char c2 : t.toCharArray())  word2.put(c2,word2.getOrDefault(c2,0)+1);
        if(word1.size()!=word2.size()) return "No";
        else{
            ArrayList<Map.Entry<Character,Integer>> word1lst = new ArrayList<>(word1.entrySet());
            for(Map.Entry<Character, Integer> ele : word1lst){
                char word = ele.getKey();
                if(word2.getOrDefault(word,0)==0) return "No";
                if(!(Math.abs(word2.get(word) - ele.getValue()) <= k))  return "No";
            }
        }
        return "Yes";
    }
}