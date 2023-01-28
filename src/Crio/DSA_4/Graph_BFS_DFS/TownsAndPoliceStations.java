package Crio.DSA_4.Graph_BFS_DFS;
import java.util.*;

public class TownsAndPoliceStations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < m; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            edges.get(i).add(x);
            edges.get(i).add(y);
        }
        int s = sc.nextInt();
        ArrayList<Integer> sources = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            sources.add(sc.nextInt());
        }
        ArrayList<Integer> ans = TownsAndPoliceStations.townsAndPoliceStations(n, edges, sources);
        for (int distance : ans) {
            System.out.println(distance + " ");
        }
        sc.close();
    }

    static boolean[] visited;
    static int[] distance;
    static ArrayList<ArrayList<Integer>> adj;
    public static ArrayList<Integer> townsAndPoliceStations(int n, ArrayList<ArrayList<Integer>> edges, ArrayList<Integer> sources) {
        Queue<Integer> Q = new LinkedList<>();
        visited = new boolean[n+1];
        distance = new int[n+1];
        adj = new ArrayList<>();

        for (int S: sources){
            visited[S] = true;
            Q.add(S);
        }

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (ArrayList<Integer> A : edges){
            adj.get(A.get(0)).add(A.get(1));
            adj.get(A.get(1)).add(A.get(0));
        }

        MultiSourceBFS(adj,Q);
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            result.add(distance[i]);
        }

        return result;
    }

    private static void MultiSourceBFS(ArrayList<ArrayList<Integer>> adj, Queue<Integer> Q) {
        while (!Q.isEmpty()){
            int k = Q.poll();

            for (int v : adj.get(k)){
                if(!visited[v]){
                    Q.add(v);
                    distance[v] = distance[k] + 1;
                    visited[v] = true;
                }
            }
        }
    }
}

/*
    **** GIVING TLE FOR 2 TESTCASES
    private static ArrayList<ArrayList<Integer>> adj;
    private static Set<Integer> city;

    public static ArrayList<Integer> townsAndPoliceStations(int n,ArrayList<ArrayList<Integer>>  edges,ArrayList<Integer> sources){

        LinkedList<Integer> result = new LinkedList<>();
        adj = new ArrayList<>();
        city = new HashSet<>(sources);

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(ArrayList<Integer> A: edges){
            adj.get(A.get(0)).add(A.get(1));
            adj.get(A.get(1)).add(A.get(0));
        }

        for (int i = 1; i <= n; i++) {
            if(city.contains(i)) result.add(0);
            else{
                result.add(getClosestCity(i,n));
            }
        }

        return new ArrayList<>(result);
    }

    private static int getClosestCity(int cur,int n) {
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[cur] = 0;
        visited[cur] = true;
        Q.offer(cur);

        while (!Q.isEmpty()){
            cur = Q.poll();

            for (int vertex : adj.get(cur)){
                if(!visited[vertex]){
                    visited[vertex] = true;
                    distance[vertex] = distance[cur] + 1;
                    if(city.contains(vertex)) return distance[vertex];
                    Q.add(vertex);
                }
            }
        }
        int closestCity = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if(city.contains(i)){
                closestCity = Math.min(distance[i],closestCity);
            }
        }
        return closestCity;
    }
    */