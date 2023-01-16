package Crio.DSA_4.Recursion_and_Backtracking;
import java.io.*;
import java.util.*;

class ValidSudoku {

    private boolean isValid(char[][] board, int row, int col) {

        char ch = board[row][col];
        //check vertically
        int i = 0, j = col;
        while (i < 9){
            if(i != row) {
                if (board[i][j] == ch) return false;
            }
            i++;
        }

        //check horizontally
        i = row; j = 0;
        while (j < 9){
            if(j != col){
                if (board[i][j] == ch) return false;
            }
            j++;
        }
        return true;
    }

    public boolean validSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if( board[i][j] != '.' ){
                    if(!isValid(board,i,j)) return false;
                }
            }
        }

        return checkBox(board, 0, 0);
    }

    private boolean checkBox(char[][] board,int row,int col) {

        if(col > 6) return checkBox(board,row+3,0);
        if(row == 9) return true;

        Set<Character> set = new HashSet<>();

        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                System.out.println(i+" "+j);
                if(set.contains(board[i][j])) return false;
                else if(board[i][j] != '.') set.add(board[i][j]);
            }
        }

        return checkBox(board,row,col+3);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[9][9];
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }
        scanner.close();
        boolean result = new ValidSudoku().validSudoku(board);
        System.out.println(result);
    }
}
