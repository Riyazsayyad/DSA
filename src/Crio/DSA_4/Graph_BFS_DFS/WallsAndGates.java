package Crio.DSA_4.Graph_BFS_DFS;
import java.util.*;
import java.io.*;
class WallsAndGates {


    private static int INF = Integer.MAX_VALUE;
    public static int[][] WallsAndGates(int [][] grid , int n, int m) {
        Queue<int[]> Q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0){
                    Q.offer(new int[]{i,j});
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            int x = curr[0], y = curr[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i], newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == INF && grid[newX][newY] != -1) {
                    grid[newX][newY] = grid[x][y] + 1;
                    Q.offer(new int[] {newX, newY});
                }
            }
        }
        return grid;
    }

    public static void main(String []args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int [][] grid = new int[n + 1][m + 1];
        for ( int i = 0; i < n; i++) {
            for ( int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int [][] distance = WallsAndGates(grid, n, m);
        for ( int i = 0; i < n; i++) {
            for ( int j = 0; j < m; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/*
    private static int findGate(int[][] grid, int row, int col) {
        Queue<GatePair> Q = new LinkedList<>();
        Q.offer(new GatePair(row,col));
        int ans = 0;
        int rowL = grid.length,colL = grid[0].length;
        while (!Q.isEmpty()){
            ans++;
            GatePair obj = Q.poll();
            int r = obj.row,c = obj.col;
            if(grid[r][c] == 0) return ans;
            if(isValid(r+1,c,rowL,colL,grid)){
                Q.offer(new GatePair(r+1,c));
            }
            if(isValid(r,c+1,rowL,colL,grid)){
                Q.offer(new GatePair(r,c+1));
            }
            if(isValid(r-1,c,rowL,colL,grid)){
                Q.offer(new GatePair(r-1,c));
            }
            if(isValid(r,c-1,rowL,colL,grid)){
                Q.offer(new GatePair(r,c-1));
            }
        }
        return Integer.MAX_VALUE;
    }

    private static boolean isValid(int row, int col,int rowL, int colL,int[][] grid) {
        return row > -1 && col > -1 && row < rowL && col < colL && !visited[row][col] && grid[row][col] != -1;
    }

    private static class GatePair{
        int row,col;
        private GatePair(int row,int col){
            this.col = col;
            this.row = row;
        }
    }
*/