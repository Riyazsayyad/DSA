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

    private boolean removeCycle(ListNode head, ListNode fast, ListNode slow) {
        int count =1;
        while (true){
            slow = slow.next;
            count++;
            if(fast == slow)    break; 
        }
        //System.out.println(count);
        ListNode temp = head;
        while (temp != slow) {
            count++;
            temp = temp.next;
        }
        //System.out.println(count);
        temp = head;
        while (count >= 0){
            temp = temp.next;
            count--;
        }
        temp.next =null;

        return true;
    }
}
