package Crio.DSA_5.Mock;
import java.util.*;

public class ParkingSpace {

    public int parkingSpace(int[][] times) {
        // Using Priority Queue
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        for (int[] time : times) {
            if (!pQ.isEmpty()) {
                if (pQ.peek() <= time[0]) pQ.poll();
            }
            pQ.add(time[1]);
        }
        return pQ.size();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] times = new int[n][2];

        for(int i = 0 ; i < n ;i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
        }

        int result = new ParkingSpace().parkingSpace(times);

        System.out.printf("%d", result);
    }
}
