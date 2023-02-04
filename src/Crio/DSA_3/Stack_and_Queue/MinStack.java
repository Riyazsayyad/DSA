package Crio.DSA_3.Stack_and_Queue;

import java.util.*;


class MinStack {
    static Stack<Integer> stack = new Stack<Integer>();
    static Stack<Integer> min = new Stack<Integer>();

    static void push(Integer e) {
        stack.push(e);
        int putB =0;
        if(min.isEmpty()){
            min.push(e);
        }else {
            if (min.peek() < e) {

                while (!min.isEmpty() && e > min.peek()) {
                    stack.push(min.pop());
                    ++putB;
                }
                while (putB != 0) {
                    --putB;
                    min.push(stack.pop());
                }
            } else min.push(e);
        }
    }
    static void pop() {
        if(stack.isEmpty()) stack.add(-1);
        if(min.isEmpty()) min.add(-1);

        min.remove(stack.pop());
    }
    static Integer findMin() {
        if(!min.isEmpty()) return min.peek();
        return -1;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            Integer a = sc.nextInt();
            if (a == 1) {
                Integer e = sc.nextInt();
                push(e);
            }
            if (a == 2) {
                pop();
            }
            if (a == 3) {
                System.out.println(findMin());
            }
        }
    }
}
