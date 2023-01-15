package Crio.DSA_4.Recursion_and_Backtracking;

import java.util.*;

public class NQueens {

    // Initiator method
    String ans = "";
    String nQueens(int n) {
        int [][] board = new int [n][n];
        placeQueen(board,0,n);
        return ans.length() == 0 ? "No Solution Exists" : ans;
    }

    // Method to solve
    private void placeQueen(int[][] board, int row,int n) {

        if(row == n){
            addToList(board,n);
            return;
        }

        for(int i = 0;i < n;i++){
            if(isValidate(board,i,row)) {
                board[row][i] = 1;
                placeQueen(board,row + 1,n);
                board[row][i] = 0;
            }
        }
    }

    // To add string input to ans string
    private void addToList(int[][] board, int n) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp.append(board[i][j]);
            }
            temp.append("\n");
        }
        ans = temp.toString()+"\n" + ans;
    }

    private boolean isValidate(int[][] board, int col, int row) {

        //Check vertical col
        int n = board.length;
        for (int[] ints : board) {
            if (ints[col] == 1) return false;
        }

        //Check upper left diagonal
        int R = row,C = col;
        while (R >= 0 && C < n){
            if(board[R][C] == 1) return false;
            R--; C++;
        }

        //Check upper right diagonal
        R = row; C = col;
        while (R >= 0 && C >=0){
            if(board[R][C] == 1) return false;
            R--; C--;
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        scanner.close();
        NQueens result = new NQueens();
        String board = result.nQueens(n);
        System.out.println(board);
    }
}
