package Crio.DSA_4.Greedy_Algo;

import java.util.*;


class ActivitySelection{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int starting[]=new int[n];
        int ending[]=new int[n];
        for(int i=0;i<n;i++)
        {
            starting[i]=sc.nextInt();
            ending[i]=sc.nextInt();
        }
        System.out.println(activitySelection(n,starting,ending));

    }

    static int activitySelection(int n, int starting[], int ending[]){
        int[][] activity = new int[n][2];

        for (int i = 0; i < n; i++) {
            activity[i][0] = starting[i];
            activity[i][1] = ending[i];
        }


        Arrays.parallelSort(activity,Comparator.comparingInt(a->a[1]));
        int count = 1,last = activity[0][1];


        for (int i = 1; i < n ; i++) {
            if( last <= activity[i][0]){
                last = activity[i][1];
                count++;
            }
        }

        return count;
    }
}
