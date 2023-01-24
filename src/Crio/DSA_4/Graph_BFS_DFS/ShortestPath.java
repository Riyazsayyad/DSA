package Crio.DSA_4.Graph_BFS_DFS;
import java.util.*;

class ShortestPath{
    public static int n;
    public static int m;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<m;i++){
            edges.add(new ArrayList<Integer>());
            edges.get(i).add(sc.nextInt());
            edges.get(i).add(sc.nextInt());
        }
        int source,destination;
        source = sc.nextInt();
        destination = sc.nextInt();
        sc.close();
        List<Integer> ans = ShortestPath.shortestPath(n,edges,source,destination);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }

    }

    // Implement Your Solution Here
    static ArrayList<ArrayList<Integer>> adj;
    static ArrayList<Integer> ans;
    static int[] values, parent;
    public static List<Integer> shortestPath(int n,ArrayList<ArrayList<Integer>> edges,int source,int destination){
        adj = new ArrayList<>();
        ans = new ArrayList<>();
        values = new int[n+1];
        parent = new int[n+1];
        PriorityQueue<PathPairs> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            if(i == source){
                values[i] = 0;
                pQ.offer(new PathPairs(0,i));
            }
            else{
                values[i] = Integer.MAX_VALUE;
                pQ.offer(new PathPairs(Integer.MAX_VALUE,i));
            }
            parent[i] = i;
        }

        for (ArrayList<Integer> A : edges){
            int x = A.get(0);
            int y = A.get(1);
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        while (!pQ.isEmpty()){
            PathPairs obj = pQ.poll();
            if(obj.value == destination) break;
            for (int i = 0; i < adj.get(obj.value).size(); i++) {
                int v = adj.get(obj.value).get(i);
                if(obj.weight < values[v]){
                    pQ.offer(new PathPairs(obj.weight +1,v));
                    values[v] = obj.weight + 1;
                    parent[v] = obj.value;
                }
            }
        }

        int u = destination;
        while (parent[u] != u){
            ans.add(u);
            u = parent[u];
        }
        ans.add(source);
        Collections.reverse(ans);

        return ans;
    }

    static class PathPairs{
        int weight,value;
        private PathPairs(int D, int V){
            this.weight = D;
            this.value = V;
        }
    }
}
