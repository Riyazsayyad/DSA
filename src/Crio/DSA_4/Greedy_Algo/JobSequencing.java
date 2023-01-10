package Crio.DSA_4.Greedy_Algo;

import java.util.*;


class JobSequencing{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int deadlines[]=new int[n];
        int profits[]=new int[n];

        for(int i=0;i<n;i++)
        {
            deadlines[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            profits[i]=sc.nextInt();
        }

        System.out.println(jobSequencing(n, deadlines, profits));
    }

    static int jobSequencing(int n, int deadlines[], int profits[]){
        int[][] jobs = new  int[n][2];
        int maxI = 0;
        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadlines[i];
            jobs[i][1] = profits[i];
            maxI = Math.max(deadlines[i],maxI);
        }
        int[] res = new int[maxI + 1];
        Arrays.parallelSort(jobs,(a,b) -> b[1] - a[1]);
        int jobCount = 0,profit = 0;

        for (int i = 0; i < n; i++) {
            //Finding free slot
            for (int j = jobs[i][0] - 1; j > -1; j--) {
                if(res[j] == 0){
                    res[j] = jobs[i][1];
                    jobCount++;
                    profit += jobs[i][1];
                    break;
                }
            }
        }
        return profit;
    }
}



/*
        int[][] jobs = new  int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadlines[i];
            jobs[i][1] = profits[i];
        }
        Arrays.sort(jobs,(a,b) ->{
            if(a[0] != b[0]) return  a[0] - b[0];
            else return b[1] - a[1];
        });
        int lastD = jobs[0][0],sum = jobs[0][1];

        for (int[] J: jobs){
            if(J[0] != lastD){
                lastD = J[0];
                sum += J[1];
            }
        }

        return sum;

         */