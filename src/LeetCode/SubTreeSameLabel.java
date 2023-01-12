package LeetCode;

import java.util.*;

public class SubTreeSameLabel {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] result = new int[n];

        DFS(adj,0,-1,result,labels);

        return result;
    }

    private int[] DFS(List<List<Integer>> adj, int curr, int parent, int[] result, String labels) {
        int[] count = new int[26];
        char myLabel = labels.charAt(curr);
        count[myLabel - 'a'] = 1;

        for(int E : adj.get(curr)){
            if(E != parent){
                int[] childCount;
                childCount = DFS(adj,E,curr,result,labels);

                for(int i = 0; i < 26;i++){
                    count[i] += childCount[i];
                }
            }
        }
        result[curr] = count[myLabel - 'a'];
        return count;
    }

}
