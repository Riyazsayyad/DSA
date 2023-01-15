package Crio.DSA_4.Recursion_and_Backtracking;
import java.io.*;
import java.util.*;

public class WordSearch {

    boolean [][] visited = new boolean[205][205];
    public boolean exist(char[][] board, String word) {

        if(board.length == 1 && board[0].length == 1 && word.length() == 1 ){
            if(word.charAt(0) == board[0][0]) return true;
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if( isPresent(board,word,i,j,1) ) return true;
            }
        }
        return false;
    }

    private boolean isPresent(char[][] board, String word, int row, int col, int index) {
        if(word.length() == index) return true;
        char ch = word.charAt(index);
        visited[row][col] = true;

        //To check vertically up
        if(row - 1 >=0 && board[row - 1][col] == ch && !visited[row - 1][col]){
            if( ( isPresent(board,word,row - 1,col,index + 1) ) )  return true;
        }

        //To check horizontally backward
        if(col - 1 >=0 && board[row][col - 1] == ch && !visited[row][col - 1]){
            if( ( isPresent(board,word,row ,col - 1,index + 1) ) )  return true;
        }

        //To check vertically down
        if(row + 1 < board.length && board[row + 1][col] == ch && !visited[row + 1][col]){
            if( ( isPresent(board,word,row + 1,col,index + 1) ) )  return true;
        }

        //To check horizontally forward
        if(col + 1 < board[0].length && board[row][col + 1] == ch && !visited[row][col + 1]){
            if( ( isPresent(board,word,row,col + 1,index + 1) ) )  return true;
        }

        visited[row][col] = false;
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        char board[][] = new char [row][col];
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col;  j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }
        String word = scanner.next();
        scanner.close();
        boolean result = new WordSearch().exist(board , word);
        System.out.println(result);
    }
}
