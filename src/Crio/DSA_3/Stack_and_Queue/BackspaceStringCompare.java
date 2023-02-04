package Crio.DSA_3.Stack_and_Queue;

import java.util.*;

class BackspaceStringCompare {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            String S = sc.next();
            String T = sc.next();

            boolean res = backspaceStringCompare(S, T);

            if (res)
                System.out.println(true);
            else
                System.out.println(false);

        }
    }

    static boolean backspaceStringCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char a : S.toCharArray()){
            if(a=='#'){
                if(!stack1.isEmpty())   stack1.pop();
            }
            else stack1.push(a);
        }
        
        for(char b : T.toCharArray()){
            if(b=='#'){
                if(!stack2.isEmpty())   stack2.pop();
            }
            else stack2.push(b);
        }

        if(stack1.size()==stack2.size()) return (stack1.toString()).compareTo(stack2.toString()) == 0;
        return false;

    }

}
