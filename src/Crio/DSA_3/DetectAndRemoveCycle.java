package Crio.DSA_3;

public class DetectAndRemoveCycle {
    public boolean detectAndRemoveCycle(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return removeCycle(head, fast, slow);
        }
        return false;
    }
    // 1 > 2 > 3 > 4L > 6 > 7L
    // here slow and fast meet at node with val 4 ( loop between 4 - 7)
    private boolean removeCycle(ListNode head, ListNode fast, ListNode slow) {
        int count = 1;
        // finding length count between two loop points
        do {
            slow = slow.next;
            count++;
        } while (fast != slow.next);

        // incrementing tHead to next node by the count of nodes
        // in our example count will be 3
        ListNode tHead = head;
        while (count > 0){
            --count;
            tHead = tHead.next;
        }

        // for test 1L > 2L
        if(tHead == head){
            while (tHead.next != head) tHead = tHead.next;
            tHead.next = null;
            return true;
        }

        // our Thead will be on node val 3
        while (tHead.next != head.next){
            head = head.next;
            tHead = tHead.next;
        }


        tHead.next = null;
        return true;
    }
}
