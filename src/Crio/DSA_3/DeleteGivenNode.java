package Crio.DSA_3;

public class DeleteGivenNode {
    public static void deleteGivenNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        // not deleting node here, just copying value of next
        // node and deleting next node
    }
}
