package Crio.DSA_4.Heap;

import java.io.*;
import java.util.*;

class TopKFrequent {

    private double b;

    // Implement your solution by completing the below function
    static List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<NumFreqPairs> Q = new PriorityQueue<>((x,y) -> y.freq - x.freq) ;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int X: nums) map.put(X,map.getOrDefault(X,0)+1);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Q.offer(new NumFreqPairs(entry.getKey(),entry.getValue()));
        }
        List<Integer> ans = new ArrayList<>();
        while (k-- != 0){
            ans.add(Q.poll().num);
        }
        return ans;
    }

    static class NumFreqPairs{
        int num, freq;
        private   NumFreqPairs(int num,int freq){
            this.num = num;
            this.freq = freq;
        }
    }


    /*
            PriorityQueue<NumFreqPairs> Q = new PriorityQueue<>((x,y) -> y.freq - x.freq) ;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int X: nums) map.put(X,map.getOrDefault(X,0)+1);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(Q.size() < k)    Q.offer(new NumFreqPairs(entry.getKey(),entry.getValue()));
            else {
                if(Q.peek().freq < entry.getValue()){
                    Q.poll();
                    Q.offer(new NumFreqPairs(entry.getKey(),entry.getValue()));
                }
            }

        }
        List<Integer> ans = new ArrayList<>();
        while (!Q.isEmpty()) ans.add(Q.poll().num);
        return ans;
     */







    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = scanner.nextInt();

        int k = scanner.nextInt();
        scanner.close();

        List<Integer> result = topKFrequent(nums, k);
        for (Integer x: result) {
            System.out.print(x + " ");
        }
    }
}
