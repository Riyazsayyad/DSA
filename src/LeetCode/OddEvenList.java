package LeetCode;
import java.util.*;
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode iter = head;
        Set<ListNode> set = new LinkedHashSet<>();
        int count=1;
        while(iter!=null){
            if(count%2==0)  set.add(iter);
            ++count;
            iter = iter.next;
        }

        ListNode curr = head;
        ListNode tail = null;
        while(head!=null){
            if(set.contains(head.next)) head.next = head.next.next;
            tail = head;
            head = head.next;
        }

        for(ListNode node: set){
            node.next = null;
            tail.next = node;
            tail = tail.next;
        }

        return curr;
    }
}
/*
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        // `even != null` rules out the list of only 1 node
        // `even.next != null` rules out the list of only 2 nodes
        while (even != null && even.next != null) {
            // Put odd to the odd list
            odd.next = odd.next.next;

            // Put even to the even list
            even.next = even.next.next;

            // Move the pointer to the next odd/even
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
 */