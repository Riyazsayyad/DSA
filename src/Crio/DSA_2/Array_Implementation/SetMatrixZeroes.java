package Crio.DSA_2.Array_Implementation;

import java.util.*;

public class SetMatrixZeroes {
    //helper function to set the row and column to zero
    public void setZero(int[][] matrix,int rI,int cI,int r,int c){
        //loop for setting zero in Row
        for(int i=0;i<c;i++){
            matrix[rI][i] = 0;
        }
        //loop for setting zero in Column
        for(int j=0;j<r;j++){
            matrix[j][cI] = 0;
        }
    }
    //helper function to call setzero using indexes
    public void callSetzero(Stack<Integer> indexs ,int[][] matrix,int rowc , int colc){
        final int size = indexs.size()/2;
        for(int i=0;i<size;i++){
            int rowI = indexs.pop();
            int colI = indexs.pop();
            setZero(matrix,rowI,colI,rowc,colc);
        }

    }

    public void setMatrixZeroes(int[][] matrix) {
        int rowC = matrix.length;
        int colC = matrix[0].length;
        Stack<Integer> indexS = new Stack<Integer>();

        for (int a = 0; a < rowC; a++){
            for (int b = 0; b < colC; b++) {
                if(matrix[a][b]==0){
                    //collecting the indexes of zero
                    //pushing col first as  stack follows LIFO
                    indexS.push(b); indexS.push(a);}
            }
        }callSetzero(indexS,matrix,rowC,colC);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[][] matrix = new int[m][n];

        for(int i = 0 ; i < m ; ++i) {
            for(int j = 0 ; j < n ; ++j) {
                matrix[i][j] = in.nextInt();
            }
        }

        in.close();
        new SetMatrixZeroes().setMatrixZeroes(matrix);

        for(int i = 0 ; i < m ; ++i) {
            for(int j = 0 ; j < n ; ++j) {
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
