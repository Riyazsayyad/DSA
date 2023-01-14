package Crio.DSA_4.Recursion_and_Backtracking;

import java.util.*;

class CombinationSum{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] candidates = new int[n];
        for(int i=0;i<n;i++){
            candidates[i] = sc.nextInt();
        }
        List<List<Integer>>res = combinationSum(candidates, target);
        if(res.size()==0){
            System.out.println("NA\n");
        }
        else{
            for(int i=0;i<res.size();i++){
                for(int j=0;j<res.get(i).size();j++){
                    System.out.print(res.get(i).get(j)+" ");
                }
                System.out.print("\n");
            }
        }
        sc.close();
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> pair = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int C: candidates) set.add(C);
        int[] E = new int[set.size()];
        int i = 0;
        for (int A: set) {
            E[i++] = A;
        }
        Arrays.sort(E);

        makeCombination(E,0,target,0,pair,result);
        return result;
    }

    private static void makeCombination(int[] A,int index,int target,int sum,List<Integer> pair,List<List<Integer>> result) {

        if(sum > target) return;

        // base case
        if(index == A.length){
            if(sum == target){
                result.add(new ArrayList<>(pair));
            }
            return;
        }

        sum += A[index];
        pair.add(A[index]);
        makeCombination(A,index,target,sum,pair,result);
        sum -= A[index];
        pair.remove(pair.size()-1);

        //exclusion
        makeCombination(A,index + 1,target,sum,pair,result);
    }
}


