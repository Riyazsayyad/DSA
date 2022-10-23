package Crio.DSA_1;
import java.io.*;
import java.util.*;

public class ValidParenthesis {
    // Implement your solution here
    public String isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char check;
        if(s.charAt(0) == '}' || s.charAt(0) == ')' || s.charAt(0) == ']')
            return "false";
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else
                if(stack.empty())
                    return "true";
                switch (s.charAt(i)) {
                    case ')':
                        check = stack.pop();
                        if (check == '{' || check == '[')
                            return "false";
                        break;
                    case '}':
                        check = stack.pop();
                        if (check == '(' || check == '[')
                            return "false";
                        break;
                    case ']':
                        check = stack.pop();
                        if (check == '{' || check == '(')
                            return "false";
                        break;
                }
        }
        if(stack.isEmpty())
            return "true";
        return "false";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String parenthesis = "{}()[]";
        String result = new ValidParenthesis().isValid(parenthesis);
        System.out.print(String.valueOf(result));
    }
}
