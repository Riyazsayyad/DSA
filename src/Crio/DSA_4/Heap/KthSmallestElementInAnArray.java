package Crio.DSA_4.Heap;

import java.util.*;

class KthSmallestElementInAnArray {

    // Implement your solution by completing the below function
    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> Q = new PriorityQueue<>((x,y) -> y-x);
        for (int n: nums){
            if(Q.size() < k) Q.offer(n);
            else{
                if(Q.peek() > n){
                    Q.poll();
                    Q.offer(n);
                }
            }
        }
        return Q.poll();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = scanner.nextInt();

        int k = scanner.nextInt();
        scanner.close();

        int result = new KthSmallestElementInAnArray().findKthSmallest(nums, k);
        System.out.println(result);
    }
}
