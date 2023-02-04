package Crio.DSA_1.Using_Collections;

import java.util.PriorityQueue;
import java.util.Scanner;

class SortArray {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        String arr[] = {"abc" ,"abd" ,"ab" ,"a"};

//        for (int i = 0; i < n; i++)
//            arr[i] = sc.next();

        String sortedArr[] = sortArray(n, arr);

        for (String word : sortedArr)
            System.out.print(word + " ");
    }

    // TODO: Implement this method
    static String[] sortArray(int n, String[] arr) {
        //System.out.println(arr[2]);
        java.util.Arrays.sort(arr);
        PriorityQueue<Integer> Ass = new PriorityQueue<Integer>();

        return arr ;
    }
}
