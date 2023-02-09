package Crio.DSA_3.Linked_List;

public class ReverseEvenElements {
    public static ListNode revLL(ListNode head){
        ListNode curr = head, prev = null;
        while (curr != null && curr.val % 2 == 0){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head.next = curr;
        return prev;
    }

    public ListNode reverseEvenElements(ListNode head)
    {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, curr= head;

        while (curr != null){
            if(curr.val %2 == 0) prev.next = revLL(curr);
            prev = curr;
            curr = curr.next;
        }
        return  dummy.next;
    }
}

/*
    {
        // passed 16/17 test cases
        ListNode curr = head, sHead =null, sTail =null, prev = null;
        while (curr != null && curr.next != null){
            if(curr.val % 2==0 && curr.next.val % 2==0){
                sHead = curr;
                while ( curr!=null && curr.val % 2 == 0) curr = curr.next;
                sTail = curr;
                if(sTail == null && sHead == head) return revLL(sHead,sTail);
                else if(sTail == null){
                    sHead.next = null;
                    return head;
                }
                else if(prev != null)prev.next = revLL(sHead,sTail);
                else head = revLL(sHead,sTail);
                sHead.next = sTail;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
 */