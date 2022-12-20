package Crio.DSA_3;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
<<<<<<< HEAD
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
=======
        
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
>>>>>>> 1a64942ba5e61439a965c76b54926fd875d80761
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

<<<<<<< HEAD


=======
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
>>>>>>> 1a64942ba5e61439a965c76b54926fd875d80761
}