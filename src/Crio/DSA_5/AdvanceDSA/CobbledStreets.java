package Crio.DSA_5.AdvanceDSA;
import java.util.*;
public class CobbledStreets {
    public static int cobbledStreets(int n, ArrayList<ArrayList<Integer>> street, int p){
        HashMap<Integer,ArrayList<int[]>> Graph = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            Graph.put(i,new ArrayList<>());
        }

        for(ArrayList<Integer> A : street){
            Graph.get(A.get(0)).add(new int[]{A.get(1),A.get(2)});
            Graph.get(A.get(1)).add(new int[]{A.get(0),A.get(2)});
        }

        PriorityQueue<StreetCostPair> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pQ.offer(new StreetCostPair(1,0));
        HashSet<Integer> visited = new HashSet<>();
        int result = 0;

        while (!pQ.isEmpty()){
            StreetCostPair temp = pQ.poll();
            int node = temp.node,distance = temp.distance;

            if(visited.contains(node)) continue;

            visited.add(node);
            result += distance;

            for (int[] A: Graph.get(node)){
                int adjNode = A[0],distOfAdjNode = A[1];
                if(!visited.contains(adjNode)) pQ.offer(new StreetCostPair(adjNode, distOfAdjNode));
            }
        }

        return result * p;
    }

    private static class StreetCostPair{
        int node,distance;
        private StreetCostPair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,e,t,p;
        t = sc.nextInt();
        while(t>0){
            t--;
            p = sc.nextInt();
            n = sc.nextInt();
            e = sc.nextInt();
            ArrayList<ArrayList<Integer>>street = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < e; i++) {
                street.add(new ArrayList<Integer>());
                street.get(i).add(sc.nextInt());
                street.get(i).add(sc.nextInt());
                street.get(i).add(sc.nextInt());
            }
            int ans = cobbledStreets(n,street,p);
            System.out.println(ans);
        }
        sc.close();
    }
}
