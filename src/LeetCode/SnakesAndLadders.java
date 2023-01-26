package LeetCode;

import java.util.*;

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        if (n == 1) return 0;
        boolean[][] visited = new boolean[n][n];
        Queue<Pos> Q = new LinkedList<>();
        visited[n-1][0] = true;
        Q.offer(new Pos(n-1,0));
        int ans = 0;
        while (!Q.isEmpty()){
            ans++;
            int size = Q.size();
            while (size-- != 0){
                Pos point = Q.poll();
                int r = point.row, c = point.col;
                for (int i = 1; i < 7; i++) {
                    if(c + i >= n){
                        int nR = r+1,nC = n - ((c+i) - n);
                        byte specialBox = isValidate(nR,nC,visited,board,n);
                        if(specialBox == 1){
                            visited[nR][nC] = true;
                            Q.offer(new Pos(nR,nC));
                        }
                        else if(specialBox == 2){
                            int R = board[nC][nR]/10,C = board[nC][nR]%10;
                            //Q.offer(new Pos())
                        }
                    }
                }
            }
        }
        return ans;
    }

    private byte isValidate(int nR, int nC, boolean[][] visited,int[][] board,int n) {
        if(nC > -1 && nR > -1 && nC < n && nR < n && !visited[nR][nC] && board[nR][nC] == -1){
            return 1;
        }else if(nC > -1 && nR > -1 && nC < n && nR < n && !visited[nR][nC] && board[nR][nC] > 0){
            return 2;
        }else return 3;
    }

    static class Pos{
        int row,col;
        private Pos(int row,int col){
            this.row = row;
            this.col = col;
        }
    }

}
