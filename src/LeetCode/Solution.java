package LeetCode;
import java.util.*;

class Solution {
    public static int[][] insert(int[][] A, int[] N) {
        ArrayList<int []> result = new ArrayList<>();

        int index = 0,n = A.length;

        while (index < n && A[index][1] < N[0]){
            result.add(A[index++]);
        }

        while (index < n && A[index][0] <= N[1]){
            int [] temp = A[index++];

            N[0] = Math.min(temp[0],N[0]);
            N[1] = Math.max(temp[1],N[1]);
        }
        result.add(N);

        while (index < n) result.add(A[index++]);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        ///{{1,2},{3,5},{6,7},{8,10},{12,16}}; {4,8}

        int a[][] = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int b[] = {4,8};
        System.out.println(Arrays.deepToString(insert(a, b)));
    }
}

