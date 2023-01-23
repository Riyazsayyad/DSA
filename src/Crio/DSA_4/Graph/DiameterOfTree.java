package Crio.DSA_4.Graph;
import java.util.*;

class DiameterOfTree{
    static ArrayList<ArrayList<Integer>> adj ;
    static boolean[] visited;
    private static int diameterOfTree(int n,Vector<Vector<Integer>> edges)
    {
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (Vector<Integer> E : edges){
            adj.get(E.get(0)).add(E.get(1));
            adj.get(E.get(1)).add(E.get(0));
        }
        int farthestEdge = 0;
        for (int j = 1; j <= n; j++) {
            farthestEdge = Math.max(farthestEdge,dfs(j,0));
        }
        return farthestEdge;
    }

    private static int dfs(int cur,int dist) {
        visited[cur] = true;
        for(int i = 0;i < adj.get(cur).size();i++){
            System.out.println(i+" "+dist+" "+cur);
            dist =  dfs(adj.get(cur).get(i),dist)+1;
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        for(int test=0;test<t;test++)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            Vector<Vector<Integer> > edges = new Vector<Vector<Integer> >();
            for(int i=0;i<m;i++)
            {
                int u=sc.nextInt();
                int v=sc.nextInt();
                Vector<Integer> edge = new Vector<Integer>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
            System.out.println(diameterOfTree(n,edges));
        }
    }
}

/*
* BFS METHOD
    {
        if(n == 1) return 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        PriorityQueue<PathPairs> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));

        int[] weights = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(weights,Integer.MAX_VALUE); weights[1] = 0;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            if(i == 1) pQ.add(new PathPairs(0,i));
            else pQ.add(new PathPairs(Integer.MAX_VALUE,i));
        }

        for (Vector<Integer> E : edges){
            adj.get(E.get(0)).add(E.get(1));
            adj.get(E.get(1)).add(E.get(0));
        }

        while (!pQ.isEmpty()){
            PathPairs obj = pQ.poll();
            if(!visited[obj.value]){
                visited[obj.value] = true;
                for (int i = 0; i < adj.get(obj.value).size(); i++) {
                    int v = adj.get(obj.value).get(i);
                    pQ.offer(new PathPairs(obj.weight +1,v));
                    weights[v] = obj.weight + 1;
                }
            }

        }
        //System.out.println(Arrays.toString(weights));
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(weights[i],ans);
        }
        return ans;
    }

    static class PathPairs{
        int weight,value;
        private PathPairs(int D, int V){
            this.weight = D;
            this.value = V;
        }
    }
 */