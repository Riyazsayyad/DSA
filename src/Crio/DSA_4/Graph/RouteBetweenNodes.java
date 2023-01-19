package Crio.DSA_4.Graph;
import java.util.*;

public class RouteBetweenNodes {
    // Implement Solution Here
    boolean[] visited = new boolean[1005];
    boolean[] selfLoop = new boolean[1005];

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    boolean routeBetweenNodes(int source , int destination ,int n,  ArrayList<ArrayList<Integer>> edges) {
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(ArrayList<Integer> A: edges){
            int x = A.get(0);
            int y = A.get(1);

            if(x == y) selfLoop[x] = true;
            else   adj.get(x).add(y);

        }

        if(source != destination){
            isPath(source);
            return visited[destination];
        }
        else {
            if(selfLoop[source]) return true;
            return isCycle(source);
        }
    }

    private boolean isCycle(int source) {
        //DFS from source to destination
        visited[source] = true;
        for (int i = 0; i < adj.get(source).size(); i++) {
            int E = adj.get(source).get(i);
            if(!visited[E]) {
                if(isCycle(E)) return true;
            }else return true;
        }
        return false;
    }



    private void isPath(int source) {
        //DFS from source to destination
        visited[source] = true;
        for (int i = 0; i < adj.get(source).size(); i++) {
            int E = adj.get(source).get(i);
            if(!visited[E]) isPath(E);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int p = 0 ; p < t ; p++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();

            for(int i=0;i<m;i++){
                edges.add(new ArrayList<Integer>());
                edges.get(i).add(scanner.nextInt());
                edges.get(i).add(scanner.nextInt());
            }
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            RouteBetweenNodes answer = new RouteBetweenNodes();
            boolean result = answer.routeBetweenNodes(src, dest,n,edges);
            if (result) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        scanner.close();
    }
}
