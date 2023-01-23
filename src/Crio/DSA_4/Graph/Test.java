package Crio.DSA_4.Graph;

import java.util.*;

class Test{

    public static void main(String[] args) {
/*
4 4
0 1
1 2
2 3
3 3
 */
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(3);
        System.out.println(isCyclic(4,adj));
    }
    // Function to detect cycle in a directed graph.
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = V;
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];


        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                if(isCyclicX(i,visited,recStack,adj)) return true;
            }

        }
        return false;
    }


    private static boolean isCyclicX(int curr,boolean[] visited,boolean[] callStack,ArrayList<ArrayList<Integer>> adj) {

        visited[curr] = true;
        callStack[curr] = true;
        if(adj.get(curr).size() > 0) {
            for (int u : adj.get(curr)) {
                if(!visited[u])  {
                    if(isCyclicX(u,visited,callStack,adj)) return true;
                }
                else if(callStack[u]) return false;
            }
        }
        callStack[curr] = false;
        return false;
    }

}