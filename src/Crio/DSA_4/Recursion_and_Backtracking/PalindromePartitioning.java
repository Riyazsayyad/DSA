package Crio.DSA_4.Recursion_and_Backtracking;
import java.util.*;

public class PalindromePartitioning {
    ArrayList<ArrayList<String>> palindromePartitioning(String s) {
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        ArrayList<ArrayList<String> > result = new PalindromePartitioning().palindromePartitioning(s);
        for(int i = 0 ; i < result.size() ; i++) {
            for(int j = 0 ; j < result.get(i).size() ; j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
