package LeetCode;

public class ReverseKGroupLL {
    private ListNode reverseLL(ListNode head,ListNode tail){
        ListNode prev = tail,nxt = null, curr = head;
        while(curr != tail){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode curr = head,tail = head;
        int count = 0;
        while(tail != null && count < k){
            tail = tail.next;
            count++;
        }
        if(count == k){
            ListNode nHead = reverseLL(curr,tail);
            curr.next = reverseKGroup(tail,k);
            return nHead;
        }
        return head;
    }
}
