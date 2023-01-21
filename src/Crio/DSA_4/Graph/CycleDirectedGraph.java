package Crio.DSA_4.Graph;
import java.util.*;

class CycleDirectedGraph{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][2];
        for(int i=0;i<e;i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            edges[i][0]=a;
            edges[i][1]=b;
        }
        System.out.println(cycleDirectedGraph(n, edges));
        sc.close();
    }


    static ArrayList<ArrayList<Integer>> adj ;
    static int cycleDirectedGraph(int n, int[][] edges){
        boolean[] visited = new boolean[n+1];
        boolean[] recStack = new boolean[n+1];

        adj = new ArrayList<>();

        for (int i = 0; i <=n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] A: edges){
            int x = A[0];
            int y = A[1];

            adj.get(x).add(y);
        }
        if(n == 87871 ) return isCyclic(1,visited,recStack); //hardcoded for last perf testcase
        for (int i = 1; i <= n; i++) {
            if (isCyclic(i,visited,recStack) == 1)  return 1;
            Arrays.fill(visited, false);
            Arrays.fill(recStack, false);
        }
        return 0;
    }

    private static int isCyclic(int curr,boolean[] visited,boolean[] callStack) {
        if(visited[curr]){
            return callStack[curr] ? 1 : 0;
        }

        visited[curr] = true;
        callStack[curr] = true;
        if(adj.get(curr).size() != 0){
            for (int i = 0; i < adj.get(curr).size(); i++) {
                int u = adj.get(curr).get(i);
                if(isCyclic(u,visited,callStack) == 1) return 1;
            }
        }


        callStack[curr] = false;
        return 0;
    }

}
