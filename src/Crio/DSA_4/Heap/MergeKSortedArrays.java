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

        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> Q = new PriorityQueue<>();

        for(ArrayList<Integer> arr: arrays) Q.addAll(arr);
        while(!Q.isEmpty()) ans.add(Q.poll());
        return ans;
    }
}
