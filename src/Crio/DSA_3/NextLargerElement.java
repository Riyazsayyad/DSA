package Crio.DSA_3;

import java.util.*;
class NextLargerElement {

    static int [] nextLargerElement(int nums[], int n) {
        Stack<Integer> stack = new Stack<>();
        //1 3 2 4 : 3 4 4 -1
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i]){ //just  accessing indexes where arr[i] is greater
                int popI = stack.pop();                            // and inserting greater element there
                nums[popI] = nums[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            nums[stack.pop()] = -1;
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        int [] ans = nextLargerElement(ar, n);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}