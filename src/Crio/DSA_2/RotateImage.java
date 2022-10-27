package Crio.DSA_2;

import java.io.IOException;
import java.util.Scanner;

public class RotateImage {

    public void rotateImage(int[][] matrix) {

        // 0 ms solution
        int n = matrix.length-1;
        int mS = matrix.length;
        int [][] res = new int[n+1][n+1];

        for (int i= 0;i<=n;i++){
            for(int j=n;j>=0;j--){
                res[i][Math.abs(n-j)] = matrix[j][i];
            }
        }
        for (int i = 0; i < mS; ++i) {
            System.arraycopy(res[i], 0, matrix[i], 0, mS);
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
