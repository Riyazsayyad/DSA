package Crio.DSA_3;

import java.util.*;


class NextSmallerElement{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int [] ans = nextSmallerElement(arr, n);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
    }

//8 2 5 10 4
//        2 -1 4 4 -1
    static int [] nextSmallerElement(int arr[], int n){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                int popI = stack.pop();
                arr[popI] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        return arr;
    }
}
