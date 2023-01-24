package LeetCode;

import java.util.*;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Pos> Q = new LinkedList<>();

    }
    static class Pos{
        int row,col;
        private Pos(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
}
