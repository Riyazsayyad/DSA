package Crio.DSA_4.Graph;

import java.util.*;
class PossibleBipartition {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int visited[] = new int[1005];
    static int color[] = new int[1005];
    private static String possibleBipartition(int n, Vector<Vector<Integer> > edges) {
        for (int i = 0; i <= n ; i++) {
            adj.add(new ArrayList<>());
        }

        for (Vector<Integer> A : edges){
            int a = A.get(0);
            int b = A.get(1);

           adj.get(a).add(b);
           adj.get(b).add(a);
        }

        for (int i = 1;i <=n;i++){
            if(visited[i] != 1){
                if(!isPossible(i)) return "Not Possible";
            }
        }
        return "Possible";
    }

    private static boolean isPossible(int curr) {
        visited[curr] = 1;
        color[curr] = 5;
        for (int i = 1;i <= adj.get(curr).size();i++){
            int v = adj.get(curr).get(i);
            if (color[i] == 0 ){
                color[i] = 6;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tests = 0; tests < t; tests++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Vector<Vector<Integer> > edges = new Vector<Vector<Integer> >();
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                Vector<Integer> edge = new Vector<Integer>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
            System.out.println(possibleBipartition(n, edges));
        }
        sc.close();
    }
}
