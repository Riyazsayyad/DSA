package Crio.DSA_3.Linked_List;

public class MoveMiddleToHead {
	public ListNode moveMiddleToHead(ListNode head) {
        //2 3 4 5 6 7
        //5 2 3 4 6 7
        if(head == null || head.next == null)    return head;
        ListNode fast = head, slow = head, prev = slow;
        while (fast!=null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        slow.next = head;
        return slow;
	}
}
