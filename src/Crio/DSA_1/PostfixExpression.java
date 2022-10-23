package Crio.DSA_1;
import java.util.*;

public class PostfixExpression {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {

        String exp = "5 11 + 9 5 - + 10 *";
        //exp = exp.replace(" ","");

        int val = postfixExpression(exp);
        System.out.println(val);
    }

    // TODO: Implement this method
    static int postfixExpression(String exp) {
        Stack<Integer> stack = new Stack<>();
        String[] splited = exp.split("\\s+");
        System.out.println(Arrays.asList(splited));

        for (String ele : splited) {
                if (ele.equals("+") || ele.equals("*") || ele.equals("-")) {
                    int x = stack.pop();
                    int y = stack.pop();
                    if (ele.equals("+"))
                        stack.push(x + y);

                    else if (ele.equals("*"))
                        stack.push(x * y);

                    else if (ele.equals("-"))
                        stack.push(y - x);
                    System.out.println(stack+" Op");
                }
                else {
                    stack.push(Integer.parseInt(ele));
                    System.out.println(stack+" ad");
                }
            }
        return stack.peek();
    }
}

//        total=numstack.pop()-'0';
//        //System.out.println(stack.size()+" "+numstack.size()+" "+numstack+" "+stack);
//        var0=stack.size();
//        for(int k=0;k<var0;k++) {
//            operator = stack.pop();
//            if(operator=='+') {
//                //System.out.println(numstack.peek() - '0'+" "+k);
//                total += (numstack.pop() - '0');
//            }
//            else if(operator=='-')
//                total -= (numstack.pop() - '0');
//            else if(operator=='*')
//                total *= (numstack.pop() - '0');

        //}




