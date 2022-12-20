package Crio.DSA_3;
import java.util.*;
public class SumLists1 {
  public static ListNode sumLists1( ListNode head1 , ListNode head2) {
        ListNode ans = new ListNode(-1);
        ListNode ansH = ans;
        int val1 =0, val2 =0, sum =0, carry =0, total =0, dec =0;
        while (head1 != null || head2 != null){

            if(head1 == null) val1 =0;
            else val1 = head1.val;
            if(head2 == null) val2 =0;
            else val2 = head2.val;

            total = val1 + val2 + carry;
            dec = total % 10;
            carry = total / 10;

            ListNode node = new ListNode(dec % 10);


            ans.next = node;
            ans = node;

            if (head1 != null)head1 = head1.next;
            if (head2 != null)head2 = head2.next;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            ans.next = node;
            ans = node;
        }
        return ansH.next;
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
