package Crio.DSA_5.Mock;
import Crio.DSA_5.AdvanceDSA.CheapestFlights;

import java.util.*;


class Pandemic{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int bus[][]=new int[m][3];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<3;j++)
            {
                bus[i][j]=sc.nextInt();
            }
        }
        int src=sc.nextInt();
        int dest=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(pandemic(n,bus,src,dest,k,m));
    }

    private static class BusCost{
        int node,cost,stops;
        private BusCost(int node,int cost,int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    static int pandemic(int n, int[][] bus, int src, int dest, int k,int m){
        HashMap<Integer,ArrayList<int[]>> Graph = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            Graph.put(i,new ArrayList<>());
        }

        for(int[] A : bus){
            Graph.get(A[0]).add(new int[]{A[1],A[2]});
        }

        PriorityQueue<BusCost> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pQ.offer(new BusCost(src,0,0));
        HashSet<Integer> visited = new HashSet<>();

        while (!pQ.isEmpty()) {

            BusCost temp = pQ.poll();
            int node = temp.node, cost = temp.cost, stops = temp.stops;
            if (node == dest) return cost;
            if (stops > k) continue;
            if (visited.contains(node)) continue;

            visited.add(node);

            for (int[] a : Graph.get(node)) {
                int adjNode = a[0], costOfFlight = a[1];
                pQ.offer(new BusCost(adjNode, cost + costOfFlight, stops + 1));
            }

        }

        return -1;
    }
}
