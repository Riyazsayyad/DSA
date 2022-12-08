package Crio.DSA_3;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicates {
    public static void removeDuplicates(ListNode head)
    {
        Set<Integer> set = new HashSet<>();
        ListNode curr = head , prev = null;
        while (curr != null){
            if(set.contains(curr.val)){
                prev.next = curr.next;
            }else {
                set.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }
    }
}
