package Crio.DSA_3;

import java.util.*;


class LongestValidParentheses {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int ans = longestValidParentheses(S);
        System.out.println(ans);
    }

    static int longestValidParentheses(String s) {

        //()(()(())
        /*
        [-1, 0] adding index of closing bracket
        [-1]    if size >1 calculating length till i and moving ahead
        [-1, 2] the index at which string is invalid will stay there as there will be no closing bracket for it
        [-1, 2, 3] thus we can get  longest valid substring
        [-1, 2]
        [-1, 2, 5]
        [-1, 2, 5, 6]
        [-1, 2, 5]
        [-1, 2]
         */
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i); // add kro index ( ka
            else {
                if (stack.size() > 1){ // pehle uska pichle wala nikala q ki wha tk valid sstring thi
                    stack.pop();
                    maxLen = Math.max(maxLen, (i - stack.peek()));  }
                else { // gives condition jahase tottally nayi valid string shuru hongi 'my future self best of luck ye padhte hue bhai'
                    stack.pop();
                    stack.push(i);
                }
                }
        }
        return maxLen;
    }
}