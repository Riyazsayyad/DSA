package Crio.DSA_2;
import java.util.*;
public class MeetingRooms {
    public int findNumRooms(int[][] intervals) {
        // Using Priority Queue
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i=0;i<intervals.length;i++){
            if (!pQ.isEmpty()) {
                if (pQ.peek() <= intervals[i][0])   pQ.poll();
            }
            pQ.add(intervals[i][1]);
        }return pQ.size();

        /*
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            A.add(intervals[i][0]);
            B.add(intervals[i][1]);
        }
        Collections.sort(A);
        Collections.sort(B);
        int i=1,j=0;
        int res=1,cs=1;
        while (i<A.size() && j<A.size()){
            System.out.println(res+" "+cs+" "+i+" "+j);
            if(A.get(i) < B.get(j)){
                cs++;
                i++;
            }else{
                cs--;
                j++;
            }
            res =Math.max(cs,res);
        }
    return res;

         */
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nums = new int[n][2];

        for(int i = 0 ; i < n ;i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        int result = new MeetingRooms().findNumRooms(nums);

        System.out.printf("%d", result);
    }
}
