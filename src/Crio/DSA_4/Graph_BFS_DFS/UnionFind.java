package Crio.DSA_4.Graph_BFS_DFS;

import java.util.ArrayList;

public class UnionFind {

    private int[] parent;
    private int[] rank;

    public int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) return;


        if (rank[xParent] > rank[yParent]) parent[yParent] = xParent;
        else if (rank[xParent] < rank[yParent]) parent[xParent] = yParent;
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;

        for(int[] A : connections){
            if(find(A[0]) != find(A[1])){
                components--;
                union(A[0],A[1]);
            }
        }

        return components-1;
    }
}

