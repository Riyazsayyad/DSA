package Crio.DSA_4.Greedy_Algo;

import LeetCode.SingleThreadedCPU;
import javafx.css.StyleableBooleanProperty;

import java.util.*;


class MinimumPlatforms{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int arrival[]=new int[n];
        int departure[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arrival[i]=sc.nextInt();
            departure[i]=sc.nextInt();
        }
        System.out.println(minimumPlatforms(n,arrival,departure));

    }

    static int minimumPlatforms(int n, int arrival[], int departure[]){
        PriorityQueue<Pairs> Q = new PriorityQueue<>((a,b) ->{
            if(a.time != b.time) return a.time - b.time;
            else return a.type - b.type;
        });
        for (int i = 0; i < n; i++) {
            Q.offer(new Pairs(arrival[i],'A'));
            Q.offer(new Pairs(departure[i],'D'));
        }
        int count = 0,maxCount = 0;
        while (!Q.isEmpty()){
            if(Q.poll().type == 'A'){
                count++;
                maxCount = Math.max(count,maxCount);
            }
            else count--;
        }
        return maxCount;
    }
    private static class Pairs{
        int time;
        char type;
        private Pairs(int time,char type){
            this.time = time;
            this.type = type;
        }
    }
}

