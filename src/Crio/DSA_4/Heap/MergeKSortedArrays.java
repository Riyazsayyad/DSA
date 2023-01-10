package Crio.DSA_4.Heap;

import java.util.*;


class MergeKSortedArrays{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            ArrayList<Integer> array = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                array.add(sc.nextInt());
            }
            arrays.add(array);
        }
        ArrayList<Integer> ans = mergeKSortedArrays(arrays);
        for (Integer x: ans) {
            System.out.print(x + " ");
        }
    }

    static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arrays){
        PriorityQueue<Pairs> Q = new PriorityQueue<>( Comparator.comparingInt(a -> a.val));
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            Q.offer(new Pairs(new int[]{i,0}, arrays.get(i).get(0)));
        }

        while (!Q.isEmpty()){
            Pairs temp = Q.poll();
            ans.add(temp.val);
            int row = temp.index[0];
            int index = temp.index[1];

            if (index + 1 < arrays.get(row).size()){
                //index already badh gya hai pre increment se
                index++;
                Q.offer(new Pairs(new int[]{row,index}, arrays.get(row).get(index)));
            }
        }
        return ans;
    }

    private static class Pairs{
        int[] index; int val;
        private Pairs(int[] index,int val){
            this.index = index;
            this.val = val;
        }
    }
}

        /*
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> Q = new PriorityQueue<>();

        for(ArrayList<Integer> arr: arrays) Q.addAll(arr);
        while(!Q.isEmpty()) ans.add(Q.poll());
        return ans;
        */