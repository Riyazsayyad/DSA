package Crio.DSA_5.AdvanceDSA;

import java.util.*;
public class MinCostOfRoad {

    public static int minCostOfRoad(int n, ArrayList<ArrayList<Integer>> edges){
        HashMap<Integer,ArrayList<int[]>> Graph = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            Graph.put(i,new ArrayList<>());
        }

        for(ArrayList<Integer> A : edges){
            Graph.get(A.get(0)).add(new int[]{A.get(1),A.get(2)});
            Graph.get(A.get(1)).add(new int[]{A.get(0),A.get(2)});
        }

        PriorityQueue<CostPair> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pQ.offer(new CostPair(1,0));
        HashSet<Integer> visited = new HashSet<>();
        int result = 0;

        while (!pQ.isEmpty()){
            CostPair temp = pQ.poll();
            int node = temp.node,distance = temp.distance;

            if(visited.contains(node)) continue;

            visited.add(node);
            result += distance;

            for (int[] A: Graph.get(node)){
                int adjNode = A[0],distOfAdjNode = A[1];
                if(!visited.contains(adjNode)) pQ.offer(new CostPair(adjNode, distOfAdjNode));
            }
        }
        return result;
    }

    private static class CostPair{
        int node,distance;
        private CostPair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,e;
        n = sc.nextInt();
        e = sc.nextInt();
        ArrayList<ArrayList<Integer>>edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < e; i++) {
            edges.add(new ArrayList<Integer>());
            edges.get(i).add(sc.nextInt());
            edges.get(i).add(sc.nextInt());
            edges.get(i).add(sc.nextInt());
        }
        int ans = minCostOfRoad(n,edges);
        System.out.print(ans);
        sc.close();
    }
}
