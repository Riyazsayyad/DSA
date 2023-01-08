package Crio.DSA_4.Greedy_Algo;

import java.util.*;


class FractionalKnapsack{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,w;
        n=sc.nextInt();
        w=sc.nextInt();

        int wt[]=new int[n];
        int val[]=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        System.out.println(String.format("%.6f",fractionalKnapsack(n,w,wt,val)));
    }

    static class ItemValue {
        Double cost;
        double wt, val, ind;

        public ItemValue(int wt, int val, int ind)
        {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = (double)((double)val/(double)wt);
        }
    }
    static double fractionalKnapsack(int n, int capacity, int[] wt, int[] val)
    {
        double[][] sack = new double[wt.length][2] ;
        for (int i = 0; i < wt.length; i++) {
            double w = (double)val[i]/wt[i];
            sack[i][0] = w;
            sack[i][1] = i;
        }
        Arrays.parallelSort(sack,Comparator.comparingDouble(a ->a[0]));
        double ans =0;
        for (int i = wt.length-1; i > -1 ; i--) {
            int index = (int) sack[i][1];
            if(wt[index] <= capacity){
                capacity -= wt[index];
                ans += val[index];
            }else {
                ans += sack[i][0] * capacity;
                break;
            }
        }
        return ans;
    }



}
