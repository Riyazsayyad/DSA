package Crio.DSA_3;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode midNext = mid.next;

        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midNext);

        return sortedMerge(left,right);
    }

    private ListNode getMid(ListNode head) {
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private ListNode sortedMerge(ListNode left, ListNode right) {
        ListNode res = null;
        if(left == null)    return right;
        if(right == null)    return left;

        if(left.val <= right.val){
            res = left;
            res.next = sortedMerge(left.next,right);
        }else {
            res = right;
            res.next = sortedMerge(left,right.next);
        }
        return res;
    }



}
