package LeetCode;

import java.util.Arrays;

public class MinFallingPathSum {

    public int getMin(int[][] mat,int a, int b,int w){
        int min = Math.min(mat[(a+1)%w][(b-1)%w],mat[(a+1)%w][(b)%w]);
        min = Math.min(min,mat[(a+1)%w][(b+1)%w]);
        return min;
    }
    public int minFallingPathSum(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int minSum = Integer.MAX_VALUE,sum =0;
        for (int i = 1; i < w; i++) {
            for (int j = 0; j < h; j++) {
                sum += getMin(matrix,i,j,w);
            }
            minSum = Math.min(sum,minSum);
            sum = 0;
        }
        return minSum;
    }

    public  void main(String[] args) {
        int[][] arr = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(arr));
    }
}
