package Crio.DSA_5.AdvanceDSA;
import java.util.*;

public class CheapestFlights {

    private static class FlightCost{
        int node,cost,stops;
        private FlightCost(int node,int cost,int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapestFlights(int n, ArrayList<ArrayList<Integer>>flight, int source, int des, int k){
        HashMap<Integer,ArrayList<int[]>> Graph = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            Graph.put(i,new ArrayList<>());
        }

        for(ArrayList<Integer> A : flight){
            Graph.get(A.get(0)).add(new int[]{A.get(1),A.get(2)});
        }

        PriorityQueue<FlightCost> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pQ.offer(new FlightCost(source,0,0));
        HashSet<Integer> visited = new HashSet<>();

        while (!pQ.isEmpty()) {

            FlightCost temp = pQ.poll();
            int node = temp.node, cost = temp.cost, stops = temp.stops;
            if (node == des) return cost;
            if (stops > k) continue;
            if (visited.contains(node)) continue;

            visited.add(node);

            for (int[] a : Graph.get(node)) {
                int adjNode = a[0], costOfFlight = a[1];
                pQ.offer(new FlightCost(adjNode, cost + costOfFlight, stops + 1));
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>>flight = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < e; i++) {
            flight.add(new ArrayList<Integer>());
            flight.get(i).add(sc.nextInt());
            flight.get(i).add(sc.nextInt());
            flight.get(i).add(sc.nextInt());
        }
        int source = sc.nextInt();
        int des = sc.nextInt();
        int k = sc.nextInt();
        int ans = cheapestFlights(n,flight,source,des,k);
        System.out.print(ans);
        sc.close();
    }
}
