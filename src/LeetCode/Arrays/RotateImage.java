package LeetCode.Arrays;

import java.io.IOException;
import java.util.Scanner;

public class RotateImage {
    // O(n^2), must come up with something optimal
    public void rotateImage(int[][] matrix) {
        int n = matrix.length-1;
        int mS = matrix.length;
        int [][] res = new int[n+1][n+1];

        for (int i= 0;i<=n;i++){
            for(int j=n;j>=0;j--){
                res[i][Math.abs(n-j)] = matrix[j][i];
            }
        }
        for (int i = 0; i < mS; ++i) {
            for (int j = 0; j < mS; ++j) {
                matrix[i][j] = res[i][j];
            }
        }
        return;

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        new RotateImage().rotateImage(matrix);
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
