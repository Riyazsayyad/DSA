package Crio.DSA_4.Graph;
import java.util.*;

public class ConnectedComponentsInGraph {
    ArrayList<ArrayList<Integer>> adj ;
    boolean [] visited;
    int connectedComponentsInGraph(int n,  ArrayList<ArrayList<Integer>> edges) {
        visited = new boolean[n+1];
        adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(ArrayList<Integer> A : edges){
            int x = A.get(0);
            int y = A.get(1);

            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int cur) {
        visited[cur] = true;
        for (int i = 0; i < adj.get(cur).size(); i++) {
            int u = adj.get(cur).get(i);
            if(!visited[u]) dfs(u);

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();

        for(int i = 0;i < m; i++) {
            edges.add(new ArrayList<Integer>());
            edges.get(i).add(scanner.nextInt());
            edges.get(i).add(scanner.nextInt());
        }
        ConnectedComponentsInGraph answer = new ConnectedComponentsInGraph();
        int result = answer.connectedComponentsInGraph(n, edges);
        System.out.println(result);
        scanner.close();
    }
}

