package Crio.DSA_4.Recursion_and_Backtracking;
import java.io.*;
import java.util.*;

class Permutation {
    public List<List<Integer>> permutation(int[] nums) {
        return new ArrayList<>();
    }











    public static void main(String args[]) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0 ; i < n ;i++) {
            nums[i] = scanner.nextInt();
        }

        List<List<Integer>> result = new Permutation().permutation(nums);

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < result.size(); ++i) {
            for (int j = 0; j < result.get(i).size(); ++j) {
                output.write(result.get(i).get(j)+" ");
            }
            output.write("\n");
        }
        output.flush();
    }
}