package Crio.DSA_4.Recursion_and_Backtracking;
import java.util.*;

public class BalancedBraces {
    static ArrayList<String> result = new ArrayList<>();
    ArrayList<String> balancedBraces(int n) {
        makeBraces(n,n,"");
        return result;
    }

    private void makeBraces(int left,int right,String braces) {
        if(left > right) return;

        if(left == 0 && right == 0){
            result.add(braces);
            return;
        }

        if(left > 0) makeBraces(left-1,right,braces+"(");

        if(right > 0) makeBraces(left,right-1,braces+")");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> answer = new BalancedBraces().balancedBraces(n);
        for(int i = 0 ; i < answer.size() ; i++) {
            System.out.println(answer.get(i));
        }
    }
}
