package Crio.DSA_2;

import java.util.Arrays;

public class SelectionSort {
    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] selectionSort(int[] arr){
        /*
        The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
        from the unsorted part and putting it at the beginning.
            #The subarray which already sorted.
            #The remaining subarray was unsorted.
         */
        int min = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j] && arr[min] > arr[j]){
                    min = j;
                }
                swap(arr,i,min);
            }
        }
        return arr;
    }
    public static void main(String[] args){
        int[] a = {8,5,2,9,0,25,6,98,32};
        System.out.println(Arrays.toString(selectionSort(a)));
    }
}
