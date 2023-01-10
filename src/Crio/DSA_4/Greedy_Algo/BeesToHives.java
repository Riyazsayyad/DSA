package Crio.DSA_4.Greedy_Algo;

import java.util.*;

public class BeesToHives{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> beesPositions = new ArrayList<>();
        ArrayList<Integer> hivesPositions = new ArrayList<>();
        for(int i=0;i<n;i++){
            beesPositions.add(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            hivesPositions.add(sc.nextInt());
        }
        int ans = beesToHives(n,beesPositions,hivesPositions);
        System.out.println(ans);
        sc.close();
    }
    // Implement Your Solution Here
    public static int beesToHives(int n,ArrayList<Integer> beesPositions,ArrayList<Integer> hivesPosition){
        beesPositions.sort(Integer::compareTo); hivesPosition.sort(Integer::compareTo);
        int time = 0, curr = 0;
        for (int i = 0; i < n; i++){
            curr = Math.abs(beesPositions.get(i)-hivesPosition.get(i));
            time = Math.max(curr ,time);
        }
        return time;
    }
}


/*
    {
        Collections.sort(beesPositions);    Collections.sort(hivesPosition);
        PriorityQueue<Bees> Q = new PriorityQueue<>((a,b) -> (Math.abs(b.bPos) - Math.abs(b.hPos)) - (Math.abs(a.bPos) - Math.abs(a.hPos)));
        for (int i = 0; i < n; i++) Q.offer(new Bees(beesPositions.get(i),hivesPosition.get(i)));
        return Q.peek().bPos - Q.peek().hPos;

    }
    private static class Bees{
        int bPos,hPos;
        public Bees(int bPos,int hPos){
            this.bPos = bPos;
            this.hPos = hPos;
        }
    }
    */





/*

        PriorityQueue<Integer> bQ = new PriorityQueue<>(), hQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            bQ.offer(beesPositions.get(i));
            hQ.offer(hivesPosition.get(i));
        }
        int time = 0;
        while (!bQ.isEmpty() || !hQ.isEmpty()) time = Math.max(Math.abs(bQ.poll())-Math.abs(hQ.poll()),time);
        return time;
 */