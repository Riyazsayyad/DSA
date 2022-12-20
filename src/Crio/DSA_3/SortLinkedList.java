package Crio.DSA_3;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null)   return head;

        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);

        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        while (left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                left = left.next;
            }
            else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
