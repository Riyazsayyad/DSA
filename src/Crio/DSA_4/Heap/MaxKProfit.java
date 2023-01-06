package Crio.DSA_4.Heap;
import java.util.*;

public class MaxKProfit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        long res = maxKProfit(n, b, a);

        System.out.println(res);
    }

    static long maxKProfit(int N, int B, int[] a) {
        PriorityQueue<Integer> Q = new PriorityQueue<>((x,y) -> y-x); //Max Heap
        for(int E : a) Q.offer(E);
        long cost = 0;
        while (!Q.isEmpty() && B-- != 0){
            if(Q.peek() == 0) break;
            cost += Q.peek();
            Q.offer(Q.poll()-1);
        }
        return cost;
    }
}
