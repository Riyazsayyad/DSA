package Crio.DSA_3.Linked_List;



public class DeleteKthToLast {
    public static ListNode deleteKthToLast(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while (node!=null){
            ++len;
            node=node.next;
        }
        var t = len - k;

        if(k == 0){
            node = head;
            while (t!=0){
                if(t==1) node.next = null;
                node = node.next;
                --t;
            }
            return head;
        }
        if(k == len){
            head =head.next;
            return head;
        }
        node = head;
        while (t != 0){
            if(t == 1) node.next =node.next.next;
            node = node.next;
            --t;
        }
        return head;
    }
}
