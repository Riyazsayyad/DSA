package Crio.DSA_4.Graph_BFS_DFS;
import java.util.*;
import java.io.*;
class WallsAndGates {
    static boolean[][] visited;
    static int INF = Integer.MAX_VALUE;
    public static int[][] WallsAndGates(int [][] grid , int n, int m) {
        //m and n are not absolute dimensions of the grid
        int[][] result = grid;
        visited = new boolean[n+1][m+1];
        Queue<GatePair> Q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 0) Q.offer(new GatePair(i,j));
            }
        }

        int[] X = {0,0,-1,1};
        int[] Y = {1,-1,0,0};

        while (!Q.isEmpty()){
            GatePair obj = Q.poll();
            int row = obj.row,col = obj.col;
            for (int i = 0; i < 4; i++) {
                int nR = row + X[i],nC = col + Y[i];
                if(isValid(nR,nC,n,m,grid)){
                    visited[nR][nC] = true;
                    result[nR][nC] = result[row][col] + 1;
                    Q.offer(new GatePair(nR,nC));
                }
            }
        }
        return result;
    }

    private static boolean isValid(int row, int col,int rowL, int colL,int[][] grid) {
        return row > -1 && col > -1 && row < rowL && col < colL && !visited[row][col] && grid[row][col] == INF;
    }

    private static class GatePair{
        int row,col;
        private GatePair(int row,int col){
            this.col = col;
            this.row = row;
        }
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
