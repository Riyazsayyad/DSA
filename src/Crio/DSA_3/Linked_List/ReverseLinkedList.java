package Crio.DSA_3.Linked_List;

public class ReverseLinkedList {
    public ListNode reverseLinkedList(ListNode head){
        ListNode curr = head, prev = null, nxt = head;
        while (curr!=null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
    return prev;
    }
}
