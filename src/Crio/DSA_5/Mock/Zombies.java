package Crio.DSA_5.Mock;
import java.util.*;

class Zombies{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] grid=new int[n][m];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(zombies(grid,n,m));
            t = t - 1;
        }

    }

    static int zombies(int[][] grid, int n, int m) {
        int X[] = {1, -1, 0, 0};
        int Y[] = {0, 0, -1, 1};
        int time = 0;

        //Store Targets-Zombies
        Queue<Zomb> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    Q.offer(new Zomb(i, j));
                }
            }
        }

        //Multisource BFS
        while (!Q.isEmpty()) {
            int currSize = Q.size();
            for (int i = 0; i < currSize; i++) {
                Zomb obj = Q.poll();
                int r = obj.row, c = obj.col;
                for (int j = 0; j < 4; j++) {
                    int nr = r + X[j], nc = c + Y[j];
                    if (isValid(nr, nc, grid) && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        Q.offer(new Zomb(nr, nc));
                    }
                }
            }
            time++;
        }

        for (int[] G : grid) {
            for (int p : G) {
                if (p == 1) return -1;
            }
        }

        return time;
    }

    static boolean isValid(int r, int c, int[][] grid) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    private static class Zomb{
        int row,col;
        private Zomb(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
        /*
        Queue<Zomb> Q = new LinkedList<>();
        Q.add(new Zomb(0,0));
        int X[] = {1,-1,0,0};
        int Y[] = {0,0,-1,1};
        int count = 0;
        while (!Q.isEmpty()){
            Zomb obj = Q.poll();
            count++;
            int r = obj.row,c = obj.col;
            for (int i = 0; i < 4; i++) {
                if(isValid(r + X[i],c + Y[i],grid) && grid[r][c] == 2){
                    grid[r + X[i]][c + Y[i]] = 2;
                    Q.offer(new Zomb(r + X[i],c + Y[i]));
                }
            }
        }

        for (int[] G : grid){
            for (int p: G){
                if(p == 1) return -1;
            }
        }

        return count;
    }

    static boolean isValid(int row,int col,int[][] grid){
        return row < grid.length && col < grid[0].length && row >= 0 && col >= 0 && grid[row][col] == 1;
    }
    private static class Zomb{
        int row,col;
        private Zomb(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    */
}
