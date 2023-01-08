package LeetCode;
import java.util.*;
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        PriorityQueue<NumFreqPairs> Q = new PriorityQueue<>((a, b) -> {
            if (b.freq - a.freq == 0) return (a.word).compareTo(b.word);
            else return b.freq - a.freq;
        });

        HashMap<String,Integer> map = new HashMap<>();

        for(String X: words) map.put(X,map.getOrDefault(X,0)+1);
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            Q.offer(new NumFreqPairs(entry.getKey(),entry.getValue()));
        }

        List<String> ans = new ArrayList<>();
        while (k-- != 0) ans.add(Q.poll().word);

        return ans;
    }

    static class NumFreqPairs{
        String word;
        int freq;
        private NumFreqPairs(String word,int freq){
            this.word = word;
            this.freq = freq;
        }
    }
}
