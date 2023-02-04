package Crio.DSA_1.Using_Collections;

import Crio.DSA_1.Simple_DS.The_Comparator;

import java.util.PriorityQueue;
import java.util.Scanner;


public class ReduceArray {
    // NOTE: Please do not modify this function
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = 5;

        int a[] = {2, 1, 11, 13 ,7};

//        for(int i=0;i<n;i++) {
//            a[i] = Integer.parseInt(sc.next());
//        }

        int ans = reduceArray(n, a);
        System.out.println(ans);
    }

    // TODO: Implement this method
    static int reduceArray(int n, int a[]){
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(new The_Comparator());
        for(int i=0;i<n;i++)
        {
            pQ.add(a[i]);
        }
        while(pQ.size()!=1)
        {
            pQ.add(pQ.poll()-pQ.poll());


        }
        return pQ.peek();
        }

    }



