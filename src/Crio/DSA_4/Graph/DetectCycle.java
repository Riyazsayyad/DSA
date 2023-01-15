package Crio.DSA_4.Graph;
import java.util.*;
import java.io.*;

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
            String ans = DetectCycle.detectCycle(nodes, edges);
            System.out.println(ans);
        }
        sc.close();
    }

    // Implement your Solution Here
    static boolean [] visited = new boolean[1005];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static String detectCycle(int nodes, ArrayList<ArrayList<Integer>> edges) {


        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> A : edges){
            int x = A.get(0);
            int y = A.get(1);
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        for (int i = 1; i <= nodes ; i++) {
            if(!visited[i]){
                if(isCycle(i,0)) return "Yes";
            }
        }
        return "No";
    }

    private static boolean isCycle(int cur, int par) {
        visited[cur] = true;
        for (int i = 0; i < adj.get(cur).size() ; i++) {
            int u = adj.get(cur).get(i);
            if(!visited[u]){
                if(isCycle(u,cur)) return true;
            }
            else if(visited[u] && u != par) return true;
        }
        return false;
    }

}