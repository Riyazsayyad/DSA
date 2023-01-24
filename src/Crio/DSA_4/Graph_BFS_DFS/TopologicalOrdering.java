package Crio.DSA_4.Graph_BFS_DFS;
import java.util.*;

class TopologicalOrdering{
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static Vector<Integer> ans;

    private static Vector<Integer> topologicalOrdering(int n,Vector<Vector<Integer> > edges)
    {
        visited = new boolean [n+1];
        adj = new ArrayList<>();
        ans = new Vector<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(Vector<Integer> A: edges){
            int x = A.get(0);
            int y = A.get(1);
            adj.get(y).add(x);
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]) dfs(i);
        }

        return ans;
    }

    private static void dfs(int curr) {
        visited[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            int u = adj.get(curr).get(i);
            if(!visited[u]) dfs(u);
        }
        ans.add(curr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Vector<Vector<Integer> > edges = new Vector<Vector<Integer> >();
        for(int i=0;i<e;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            Vector<Integer> edge = new Vector<Integer>();
            edge.add(u);
            edge.add(v);
            edges.add(edge);
        }
        Vector<Integer> answer = topologicalOrdering(n,edges);
        for(int elem : answer)
            System.out.print(elem+" ");
    }
}
