package Crio.DSA_4.Recursion_and_Backtracking;
import java.util.*;

public class PalindromePartitioning {
    static ArrayList<ArrayList<String>> result = new ArrayList<>();
    ArrayList<ArrayList<String>> palindromePartitioning(String s) {
        makePartitions(s,0,s.length(),new ArrayList<>());
        return result;
    }

    private void makePartitions(String s, int index,int n, ArrayList<String> temp) {

        if(index >= s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < n; i++) {
            if (isPalindrome(s,index,i)){

                temp.add(s.substring(index,i+1));
                makePartitions(s,i+1,n,temp);
                temp.remove(temp.size() - 1);

            }
        }
    }

    private boolean isPalindrome(String substring,int start,int end) {

        while (start < end){
            if(substring.charAt(start++) != substring.charAt(end--)) return false;
        }
        return true;
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
