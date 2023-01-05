package Crio.DSA_4;

import java.util.*;
public class KClosestPointsToOrigin {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> points = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> point = new ArrayList<>();
            point.add(sc.nextInt());
            point.add(sc.nextInt());
            points.add(point);
        }
        ArrayList<ArrayList<Integer>> ans = kClosestPointsToOrigin(points, k);
        for (ArrayList<Integer> point : ans) {
            System.out.println(point.get(0) + " " + point.get(1));
        }
    }

    static ArrayList<ArrayList<Integer>> kClosestPointsToOrigin(ArrayList<ArrayList<Integer>> points, int k) {
        //TC: O(nlogk)

        PriorityQueue<ArrayList<Integer>> Q = new PriorityQueue<>(
                (a,b) -> (int) Math.sqrt(Math.pow(b.get(0),2) + Math.pow(b.get(1),2)) -
                                (int) Math.sqrt(Math.pow(a.get(0),2) + Math.pow(a.get(1),2))
        );

        for (ArrayList<Integer> arr : points){
            if(Q.size() < k){
                Q.offer(arr);
            }else{
                int I = (int) Math.sqrt(Math.pow(arr.get(0),2) + Math.pow(arr.get(1),2));
                int T = (int) Math.sqrt(Math.pow(Q.peek().get(0),2) + Math.pow(Q.peek().get(1),2));
                if(I < T){
                    Q.poll();
                    Q.offer(arr);
                }
            }

        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(Q);
        return ans;
    }
}

        /*
        //TC: O(nlogn)
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (int) Math.sqrt(Math.pow(a.get(0),2) + Math.pow(a.get(1),2))));
        queue.addAll(points);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (k-- != 0){
            if(ans.isEmpty())   ans.add(queue.poll());
            else ans.add(ans.size()-1,queue.poll());
        }
        return ans;

         */


/*
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (int) Math.sqrt(Math.pow(a.get(0),2) - Math.pow(a.get(1),2))));
        for(ArrayList<Integer> point : points){
            if(queue.size() < k) queue.add(point);
            else {
                System.out.println(queue.peek());
                int I = (int) Math.sqrt(Math.pow(point.get(0),2) + Math.pow(point.get(1),2));
                int T = (int) Math.sqrt(Math.pow(queue.peek().get(0),2) + Math.pow(queue.peek().get(1),2));
                if(I < T){
                    queue.poll();
                    queue.add(point);
                }
            }
        }
        return new ArrayList<>(queue);

         */
