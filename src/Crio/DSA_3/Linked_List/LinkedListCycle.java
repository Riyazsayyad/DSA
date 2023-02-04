package Crio.DSA_3.Linked_List;



public class LinkedListCycle {
    public boolean linkedListCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
