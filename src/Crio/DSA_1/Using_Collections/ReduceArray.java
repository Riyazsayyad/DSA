package Crio.DSA_1.Using_Collections;



import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class The_Comparator implements Comparator<Integer> {
    public int compare(Integer str1, Integer str2)
    {
        Integer first;
        Integer second;
        first = str1;
        second = str2;
        return second.compareTo(first);
    }
}

public class ReduceArray {
    // NOTE: Please do not modify this function
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = 5;

        int[] a = {2, 1, 11, 13 ,7};



        int ans = reduceArray(n, a);
        System.out.println(ans);
    }

    // TODO: Implement this method
    static int reduceArray(int n, int[] a){
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



