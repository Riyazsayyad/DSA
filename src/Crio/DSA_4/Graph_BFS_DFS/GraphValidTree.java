package Crio.DSA_4.Graph_BFS_DFS;
import java.util.*;
import java.lang.Integer;

class GraphValidTree{
    static boolean[] visited ;
    static ArrayList<ArrayList<Integer>> adj;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][2];
        for(int i=0;i<m;i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            edges[i][0] = a;
            edges[i][1] = b;
        }
        System.out.println(graphValidTree(n,edges));

        sc.close();
    }

    static int graphValidTree(int n, int[][] edges){
        adj = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] A: edges){
            int x = A[0];
            int y = A[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }




        dfs(1);
        if(checkConnection(visited)) return 0;
        visited = new boolean[n+1];

        for (int i = 1; i <= n ; i++) {
            if(!visited[i]){
                if(isCycle(i,-1)) return 0;
            }
        }
        return 1;
    }

    private static boolean checkConnection(boolean[] visited) {
        for (int i = 1; i < visited.length; i++) {
            if(!visited[i]) return true;
        }
        return false;
    }

    private  static  boolean isCycle(int cur, int parent) {
        visited[cur] = true;

        for (int i = 0; i < adj.get(cur).size() ; i++) {
            int child = adj.get(cur).get(i);
            if(!visited[child]){
                if(isCycle(child,cur)) return true;
            }
            else if(visited[child] && child != parent) return true;
        }
        return false;
    }

    private static void dfs(int curr) {
        visited[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            int u = adj.get(curr).get(i);
            if(!visited[u]) dfs(u);
        }
    }
}
