package Crio.DSA_2;

import java.util.Arrays;

public class InsertionSort {
    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] selectionSort(int[] arr){
        /*
        Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands.
        The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked
        and placed at the correct position in the sorted part.
         */
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
    public static void main(String[] args){
        int[] a = {8,5,2,9,0,25,6,98,32};
        System.out.println(Arrays.toString(selectionSort(a)));
    }
}
