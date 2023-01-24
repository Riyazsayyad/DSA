package Crio.DSA_4.Graph_BFS_DFS;
import java.util.*;

class DetectCycle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while ((t--) > 0) {
            int nodes = sc.nextInt();
            int e = sc.nextInt();
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < e; i++) {
                ArrayList<Integer> b = new ArrayList<Integer>();
                b.add(sc.nextInt());
                b.add(sc.nextInt());
                edges.add(b);
            }
            DetectCycle D = new DetectCycle();
            String ans = D.detectCycle(nodes, edges);
            System.out.println(ans);
        }
        sc.close();
    }

    // visited list with default value as false
     boolean [] visited = new boolean[1005];
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>(1005);

    public  String detectCycle(int nodes, ArrayList<ArrayList<Integer>> edges) {

        // assigned adj list for each node
        for (int i = 0; i <= nodes; i++) adj.add(new ArrayList<>());

        for (ArrayList<Integer> A : edges){
            int x = A.get(0);
            int y = A.get(1);

            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        for (int i = 1; i <= nodes ; i++) {
            if(!visited[i]){
                if(isCycle(i,-1)) return "Yes";
            }
        }
        return "No";
    }

    private  boolean isCycle(int cur, int parent) {
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

}