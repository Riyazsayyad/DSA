package LeetCode;
import java.util.*;
public class Test {
    public static void main(String [] args){
        Test t = new Test() ;
        var res = t.testKarlo(2,2);
        System.out.println(res);
        Map<Character,Character> map = new HashMap<>();
        StringBuilder s = new StringBuilder();
        ListNode a = null ;
        (new ListNode(-1)).next = a;

    }
    public int testKarlo(int base,int exponent){
            if (exponent==0) return 1;
            if (exponent==1)
                return base;
            return base * testKarlo(base,exponent-1) ;
    }


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        for(int n : nums){
            if(i < k)   Q.offer(n);
            else{
                if(Q.peek() < n){
                    Q.poll();
                    Q.offer(n);
                }
            }
            i++;
        }
        return 0;
    }
}
