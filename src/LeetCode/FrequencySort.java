package LeetCode;
import java.util.*;
public class FrequencySort {
    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int n = s.length();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        StringBuilder ans = new StringBuilder();
        ArrayList<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Character,Integer> aa : list){
            for (int j = 0; j < aa.getValue(); j++) {
                ans.append(aa.getKey());
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
