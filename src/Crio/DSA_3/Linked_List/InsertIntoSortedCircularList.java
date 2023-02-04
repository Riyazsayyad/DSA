package Crio.DSA_3.Linked_List;


public class InsertIntoSortedCircularList {
    // Implement your solution here
    public ListNode insertIntoSortedCircularList(ListNode head, int insertVal)

    {
        ListNode newNode = new ListNode(insertVal);
        if(head == null){
            newNode.next = newNode;
            head = newNode;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != head){
            if((insertVal >= prev.val && insertVal <= curr.val) || (insertVal > prev.val && prev.val > curr.val) || (insertVal < curr.val && prev.val > curr.val))  break;
            curr = curr.next;
            prev = prev.next;
            }
            prev.next = newNode;
            newNode.next = curr;
            return head;
        }
//        ListNode prev = null, curr = null, minF = head;
//        ListNode minNode = new ListNode(Integer.MAX_VALUE);
//        ListNode insert = new ListNode(insertVal);
//        if (head == null){
//            head = insert;
//            head.next = head;
//            return head; }
//        while (true){
//            if (minNode.val > minF.next.val){
//                prev = minF;
//                minNode = minF.next;
//            }
//            minF = minF.next;
//            if(minF == head && minNode.val == Integer.MAX_VALUE){
//                minF = head;
//                break;
//            }
//            if(minF == head) break;
//        }
//
//        curr = minNode;
//        while (curr != null){
//            if(curr.val >= insertVal){
//                if(prev.next == minNode){
//                    prev.next = insert;
//                    insert.next = curr;
//                    return head;
//                }
//                prev.next = insert;
//                insert.next = curr;
//                return head;
//            }
//            prev = curr;
//            curr = curr.next;
//            if(curr == minNode) break;
//        }
//        curr = minNode;
//        prev = null;
//        while (true){
//            if(curr.next == head){
//                curr.next = insert;
//                insert.next = head;
//                return head;
//            }else if (curr.val >= insertVal ){
//                prev.next = insert;
//                insert.next = curr;
//                return head;
//            }
//            prev =curr;
//            curr = curr.next;
//        }
//        //return head;
    }


