package Crio.DSA_3.Linked_List;

import java.util.*;

public class ListIntersectionPoint {
    public static ListNode diffMove(ListNode node, int diff) {
        while (diff != 0){
            node = node.next;
            --diff;
        }
        return node;
    }

    public static ListNode listIntersectionPoint(ListNode head1, ListNode head2) {
        ListNode l1 = head1, l2 = head2;
        int len1 =0, len2 =0;

        while (l1 != null ){
                l1 = l1.next;
                ++len1;
        }

        while (l2 != null){
                l2 = l2.next;
                ++len2;
        }

        int diff = Math.abs(len1 - len2);
        l1 = head1; l2 = head2;
        if(len1 > len2) l1 = diffMove(l1,diff);
        else l2 = diffMove(l2,diff);

        while (l1 != null){
            if(l1 == l2) return l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }
}
/*brute force
    Set<ListNode> set = new HashSet<>();
        while (head1 != null){
                set.add(head1);
                head1 = head1.next;
                }
                while (head2 != null){
                if(set.contains(head2)) return head2;
                head2 = head2.next;
                }
                return null;
 */
