package LeetCode;
import java.util.*;
public class AddTwoNumbersLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2;
        Stack<Integer> sum1 = new Stack<>(), sum2 = new Stack<>();

        while(curr1 != null){
            sum1.push(curr1.val);
            curr1 = curr1.next;
        }

        while(curr2 != null){
            sum2.push(curr2.val);
            curr2 = curr2.next;
        }

        int carry = 0;
        ListNode ans = null;

        while(!sum1.isEmpty() || !sum2.isEmpty()){
            int sum;
            if(sum1.isEmpty()){
                sum = sum2.pop() + carry;
                ListNode node = new ListNode((int)sum % 10);
                carry = sum/10;
                node.next = ans;
                ans = node;
            }
            else if(sum2.isEmpty()){
                sum = sum1.pop() + carry;
                ListNode node = new ListNode((int)sum % 10);
                carry = sum/10;
                node.next = ans;
                ans = node;
            }
            else{
                sum = sum1.pop() + sum2.pop() + carry;
                ListNode node = new ListNode((int)sum % 10);
                carry = sum/10;
                node.next = ans;
                ans = node;
            }
        }

        if(carry != 0){
            ListNode node = new ListNode(carry);
            node.next = ans;
            ans = node;
        }

        return ans;
    }
}
