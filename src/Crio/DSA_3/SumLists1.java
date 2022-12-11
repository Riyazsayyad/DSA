package Crio.DSA_3;
import java.util.*;
public class SumLists1 {
    public static ListNode revLL(ListNode node){
        ListNode head = node, prev = null, nxt = head;
        while (head != null){
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }
    public static ListNode sumLists1( ListNode head1 , ListNode head2) {
        // Reversing LL
        ListNode nHead1 =  revLL(head1);
        ListNode nHead2 =  revLL(head2);
        ListNode ans = null;
        int val1 =0, val2 =0, sum =0, carry =0, total =0;
        while (nHead1 != null || nHead2 != null){

            if(nHead1 == null) val1 =0;
            else val1 = nHead1.val;
            if(nHead2 == null) val2 =0;
            else val2 = nHead2.val;
            // Traditional Addition Method
            total = val1 + val2 + carry;
            sum = total % 10;
            carry = total / 10;

            ListNode node = new ListNode(sum % 10);

            node.next = ans;
            ans = node;

            if (nHead1 != null)nHead1 = nHead1.next;
            if (nHead2 != null)nHead2 = nHead2.next;
        }
        // if carry exists corner case (999 + 1) : 1 carry left in the end
        if(carry != 0){
            ListNode node = new ListNode(carry);
            node.next = ans;
            ans = node;
        }
        return ans;
    }
}


/*
        Brute force approach
                ListNode list1 = head1, list2 = head2;
        int sum1 = list1.val, sum2 = list2.val;
        list1 = list1.next; list2 = list2.next;
        while (list1 != null){
            sum1 = (sum1*10) + list1.val;
            list1 = list1.next;
        }
        while (list2 != null){
            sum2 = (sum2*10) + list2.val;
            list2 = list2.next;
        }
        int total  = sum1 + sum2;
        ListNode nHead = null;
        while (total != 0) {
            ListNode node = new ListNode(total%10);
            total /= 10;
            node.next = nHead;
            nHead = node;
        }
        return nHead;
         */