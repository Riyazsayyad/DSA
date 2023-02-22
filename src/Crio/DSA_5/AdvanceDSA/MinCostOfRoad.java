package Crio.DSA_5.AdvanceDSA;
import java.util.*;
public class MinCostOfRoad {
    public static int minCostOfRoad(int n, ArrayList<ArrayList<Integer>> edges){
        return 0;
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
