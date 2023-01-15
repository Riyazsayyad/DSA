package Crio.DSA_4.Recursion_and_Backtracking;
import java.io.*;
import java.util.*;

class Subsets {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        makeSets(nums,0,new ArrayList<>(),n);
        return result;
    }

    private void makeSets(int[] nums, int index,List<Integer> A,int n) {
        result.add(new ArrayList<>(A));
        for (int i = index; i < n; i++) {
            A.add(nums[i]);
            makeSets(nums,i + 1,A,n);
            A.remove(A.size()-1);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];

        for(int i = 0 ; i < n ; ++i) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        List<List<Integer>> result = new Subsets().subsets(nums);
        System.out.println(result.size());
        for(int i = 0 ; i < result.size() ; ++i) {
            if(result.get(i).size() == 0) {
                System.out.println("null");
                continue;
            }
            for(int j = 0 ; j < result.get(i).size() ; ++j) {
                System.out.printf("%d " , result.get(i).get(j));
            }
            System.out.println();
        }
    }

}
