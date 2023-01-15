package LeetCode;
import java.util.*;

class Solution {
    // Initiator method
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int [][] board = new int [n][n];
        placeQueen(board,0,n);
        return ans;
    }

    // Method to solve
    private void placeQueen(int[][] board, int row,int n) {

        if(row == n){
            addToList(board,n);
            return;
        }

        for(int i = 0;i < n;i++){
            if(isValidate(board,i,row,n)) {
                board[row][i] = 1;
                placeQueen(board,row + 1,n);
                board[row][i] = 0;
            }
        }
    }

    // To add string input to ans string
    private void addToList(int[][] board, int n) {
        List<String> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                temp.append(board[i][j] == 0 ? "." : "Q");
            }
            A.add(temp.toString());
        }
        ans.add(A);
    }

    private boolean isValidate(int[][] board, int col, int row,int n) {

        //Check vertical col
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

}