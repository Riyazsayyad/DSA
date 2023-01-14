package LeetCode;

import java.util.ArrayList;

public class LongestPathDiffAdjacentCharacters {
    int result = 0;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int v = parent[i];
            adj.get(i).add(v);
            adj.get(v).add(i);
        }

        DFS(adj,0,-1,s);
        return result;
    }

    private int DFS(ArrayList<ArrayList<Integer>> adj, int curr, int parent, String s) {
        int longest = 0, second_longest = 0;

        for(int child: adj.get(curr)){
            if(child == parent) break;

            int child_longest_length = DFS(adj,child,curr,s);

            if(s.charAt(child) == s.charAt(curr)) break;

            if(child_longest_length > second_longest) second_longest = child_longest_length;
            if(second_longest > longest){
                int temp = second_longest;
                longest = second_longest;
                second_longest = temp;
            }
        }
        int max = Math.max(longest,second_longest)+ 1;
        int maxRoot = 1;
        int downAns = 1 + longest + second_longest;
        result = Math.max(downAns,Math.max(max,maxRoot));
        return Math.max(max,maxRoot);
    }
}
