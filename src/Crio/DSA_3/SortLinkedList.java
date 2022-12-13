package Crio.DSA_3;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        mergeSort(head);
        return head;
    }

    public void mergeSort(ListNode head) {
        ListNode tHead = head;
        if(tHead == null || tHead.next == null) return;
        ListNode a = null, b =null;
        splitLL(tHead,a,b);
        mergeSort(a);
        mergeSort(b);
        
        head = sortedMerge(a,b);
    }

    public ListNode sortedMerge(ListNode a, ListNode b) {
        ListNode res = null;
        if(a == null) return b;
        if(b == null) return a;

        if(a.val <= b.val){
            res = a;
            a.next = sortedMerge(a.next,b);
        }else {
            res = b;
            b.next = sortedMerge(a,b.next);
        }
        return res;
    }

    public void splitLL(ListNode node,ListNode a, ListNode b){
        ListNode slow =node, fast =node;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        a = node;
        b = slow.next;
        slow.next = null;
    }
}
