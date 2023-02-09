package Striver_SDE_Sheet.Day_1;
import java.util.*;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        A.add(1);
        result.add(A);
        if(numRows == 1) return result;

        B.add(1);
        B.add(1);
        result.add(B);
        if(numRows == 2) return result;

        for (int i = 2; i < numRows; i++) {
            A = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) A.add(1);
                else {
                    int sum = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    A.add(sum);
                }
            }
            result.add(A);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }
}
