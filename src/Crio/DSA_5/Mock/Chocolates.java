package Crio.DSA_5.Mock;
import java.util.*;


class Chocolates{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int [n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>>ans=new ArrayList();
        ans=chocolates(n,nums);
        for(int i=0;i<ans.size();i++)
        {
            for(int j=0;j<ans.get(i).size();j++)
            {
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }

    static List<List<Integer>> result;
    static List<List<Integer>> chocolates(int n,int[] nums){
        result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            getCombinations(0,i,nums,curr);
        }
        return result;
    }

    private static void getCombinations(int index, int k, int[] nums,ArrayList<Integer> A) {
        if(A.size() == k){
            result.add(new ArrayList<>(A));
            return;
        }

        for (int j = index; j < nums.length; j++) {
            A.add(nums[j]);
            getCombinations(j + 1, k, nums, A);
            A.remove(A.size() - 1);
        }
    }
}
