package Crio.DSA_4.Heap;

import java.util.*;

class KthLargestElementInAnArray {

    // Implement your solution by completing the below function
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int x: nums){
            if(q.size() < k) q.offer(x);
            else{
                if(x > q.peek()){
                    q.poll();
                    q.offer(x);
                }
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = scanner.nextInt();

        int k = scanner.nextInt();
        scanner.close();

        int result = new KthLargestElementInAnArray().findKthLargest(nums, k);
        System.out.println(result);
    }
}
