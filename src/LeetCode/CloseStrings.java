package LeetCode;
import java.util.*;
public class CloseStrings {
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())  return false;
        else{
            Map<Character,Integer> word1map = new HashMap<>();
            Map<Character,Integer> word2map = new HashMap<>();
            for(char a:word1.toCharArray()){
                if(word1map.containsKey(a)) word1map.replace(a,word1map.get(a)+1);
                else word1map.put(a,1); }
            for(char a:word2.toCharArray()){
                if(word2map.containsKey(a)) word2map.replace(a,word2map.get(a)+1);
                else word2map.put(a,1); }
            Set<Character> word1Set = new HashSet<>(word1map.keySet());
            Set<Character> word2Set = new HashSet<>(word2map.keySet());
            if(!word1Set.containsAll(word2Set)) return false;
            ArrayList<Integer> word1Pq = new ArrayList<>(word1map.values());
            ArrayList<Integer> word2Pq = new ArrayList<>(word2map.values());
            if(word1Pq.size()!=word2Pq.size())  return false;
            else{
                Collections.sort(word1Pq);
                Collections.sort(word2Pq);
                return word1Pq.equals(word2Pq);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba","abbccc"));
    }
}
/*
class Solution {
    public boolean closeStrings(String s1, String s2) {

        var freqs1 = new int[26];
        for(var c1: s1.toCharArray()) {
            freqs1[c1 - 'a']++;
        }
        var freqs2 = new int[26];
        for(var c2: s2.toCharArray()) {
            freqs2[c2 - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(freqs1[i]  > 0 && freqs2[i] == 0) {
                return false;
            }
            if(freqs1[i] == 0 && freqs2[i]  > 0) {
                return false;
            }
        }
        Arrays.sort(freqs1);
        Arrays.sort(freqs2);
        return Arrays.equals(freqs1, freqs2);
    }
}
 */