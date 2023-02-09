package Crio.DSA_3.Linked_List;

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

        ArrayList<Map.Entry<Character,Integer>> word1List = new ArrayList<>(word1.entrySet());
        ArrayList<Map.Entry<Character,Integer>> word2List = new ArrayList<>(word2.entrySet());

        for(Map.Entry<Character,Integer> w1 : word1List){
            if(!(Math.abs(w1.getValue()-word2.getOrDefault(w1.getKey(),0)) <=k)) return "No";
        }
        for(Map.Entry<Character,Integer> w2 : word2List){
            if(!(Math.abs(w2.getValue()-word1.getOrDefault(w2.getKey(),0)) <=k)) return "No";
        }
        return "Yes";
    }
}