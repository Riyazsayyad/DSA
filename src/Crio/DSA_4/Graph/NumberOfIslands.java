package Crio.DSA_4.Graph;
import java.io.*;
import java.util.*;

class NumberOfIslands {

    boolean[][] visited;
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1'){
                    findIsland(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void findIsland(char[][] grid, int row, int col) {
        Queue<Land> Q = new LinkedList<>();
        Q.offer(new Land(row,col));

        while (!Q.isEmpty()){
            Land obj = Q.poll();
            int r = obj.I, c = obj.J;
            visited[r][c] = true;
            //UP
            if(r + 1 < grid.length && grid[r+1][c] == '1' && !visited[r+1][c]){
                Q.add(new Land(r+1,c));
                visited[r+1][c] = true;
            }
            //DOWN
            if(r - 1 > -1 && grid[r-1][c] == '1' && !visited[r-1][c]){
                Q.add(new Land(r-1,c));
                visited[r-1][c] = true;
            }
            //RIGHT
            if(c + 1 < grid[0].length && grid[r][c+1] == '1' && !visited[r][c+1]){
                Q.add(new Land(r,c+1));
                visited[r][c+1] = true;
            }
            //LEFT
            if(c - 1 > -1 && grid[r][c-1] == '1' && !visited[r][c-1]){
                Q.add(new Land(r,c-1));
                visited[r][c-1] = true;
            }
        }
    }

    private static class Land{
        int I,J;
        private Land(int I, int J){
            this.I = I;
            this.J = J;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int columns = in.nextInt();
        char[][] grid = new char[rows][columns];

        for(int i = 0 ; i < rows ; ++i) {
            String s = in.next();
            for(int j = 0 ; j < columns ; ++j) {
                grid[i][j] = s.charAt(j);
            }
        }
        in.close();
        int result = new NumberOfIslands().numIslands(grid);
        System.out.println(result);
    }
}
