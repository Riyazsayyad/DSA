package Crio.DSA_2;

import java.util.Arrays;

public class BubbleSort {

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] bubbleSort(int[] arr){
        /*
        Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements
        if they are in the wrong order. This algorithm is not suitable for
        large data sets as its average and worst-case time complexity is quite high.
         */
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j])   swap(arr,i,j);
            }
        }
        return arr;
    }
    public static void main(String[] args){
        int[] a = {8,5,2,9,0,25,6,98,32};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }
}
