package Striver_SDE_Sheet.Day_1;

import java.util.Arrays;

public class SetZeroes {
    int[][] result;
    public void setZeroes(int[][] matrix) {
        result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, result[i], 0, matrix[0].length);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) fillZeroes(i,j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(result[i], 0, matrix[i], 0, matrix[0].length);
        }
    }

    private void fillZeroes(int row, int col) {
        int r = row,c = col;

        //set above
        while (r > -1){
            result[r--][col] = 0;
        }
        r = row;

        //set below
        while (r < result.length){
            result[r++][col] = 0;
        }
        r = row;

        //set left
        while (c > -1){
            result[r][c--] = 0;
        }
        c = col;

        //set right
        while (c < result[0].length){
            result[r][c++] = 0;
        }
    }
}
