package Crio.DSA_5.AdvanceDSA;
import java.util.*;

class NetworkDelayTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> b = new ArrayList<>();

            b.add(sc.nextInt());
            b.add(sc.nextInt());
            b.add(sc.nextInt());
            edges.add(b);
        }

        int k = sc.nextInt();

        int ans = NetworkDelayTime.networkDelayTime(n, edges, k);

        System.out.println(ans);
    }

    private static class NetworkCost{
        int node,distance;
        private NetworkCost(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public static int networkDelayTime(int N, ArrayList<ArrayList<Integer>> edges, int K) {
        HashMap<Integer,ArrayList<int[]>> Graph = new HashMap<>();

        for (int i = 0; i <= N; i++) {
            Graph.put(i,new ArrayList<>());
        }

        for(ArrayList<Integer> A : edges){
            Graph.get(A.get(0)).add(new int[]{A.get(1),A.get(2)});
        }

        PriorityQueue<NetworkCost> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pQ.offer(new NetworkCost(K,0));
        HashSet<Integer> visited = new HashSet<>();

        int result = 0;
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[K] = 0;

        while (!pQ.isEmpty()){
            NetworkCost temp = pQ.poll();
            int node = temp.node;
            if(visited.contains(node)) continue;
            visited.add(node);

            for (int[] A: Graph.get(node)){
                int adjNode = A[0],distOfAdjNode = A[1];
                if(!visited.contains(adjNode) && dist[adjNode] > dist[node] + distOfAdjNode){
                    pQ.offer(new NetworkCost(adjNode,dist[adjNode] = dist[node] + distOfAdjNode));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            result = Math.max(dist[i],result);
            if(dist[i] == Integer.MAX_VALUE) return -1;
        }

        return result;
    }
}
