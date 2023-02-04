package Crio.DSA_3.Linked_List;


import java.util.*;
public class CopyRandomList {
    Node nNode(int x){
        Node temp = new Node();
        temp.val = x;
        temp.next = null;
        temp.random = null;
        return temp;
    }

    public Node copyRandomList(Node head) {
        HashMap<Node,Node> nodes = new HashMap<>();
        Node curr = head;
        while (curr != null){
            nodes.put(curr,nNode(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null){
            nodes.get(curr).next = nodes.get(curr.next);
            nodes.get(curr).random = nodes.get(curr.random);
            curr = curr.next;
        }

        return nodes.get(head);
    }
}
