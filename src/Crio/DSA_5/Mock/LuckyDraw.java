package Crio.DSA_5.Mock;
import java.io.*;
import java.util.*;

class LuckyDraw {

    // Implement your solution by completing the below function
    public int luckyDraw(int[] tokens, int x) {
        PriorityQueue<Integer> Q = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        for(int t : tokens){
            if(Q.size() < x) Q.offer(t);
            else{
                if(t < Q.peek()){
                    Q.poll();
                    Q.offer(t);
                }
            }
        }
        return Q.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int tokens[] = new int[n];
        for (int i = 0; i < n; ++i)
            tokens[i] = scanner.nextInt();

        int x = scanner.nextInt();
        scanner.close();

        int result = new LuckyDraw().luckyDraw(tokens, x);
        System.out.println(result);
    }
}
