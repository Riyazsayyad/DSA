package Crio.DSA_4.Graph;
import java.util.*;
import java.io.*;


class MaxAreaOfIsland{

    static boolean[][] visited;
    public static int maxAreaOfIsland(ArrayList<ArrayList<Integer> > A){
        int[][] grid = new int[A.size()][A.get(0).size()];

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size();j++) {
                grid[i][j] = A.get(i).get(j);
            }
        }

        visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1){
                   maxArea = Math.max(maxArea,measureIsland(grid,i,j)) ;
                }
            }
        }
        return maxArea;
    }

    private static int measureIsland(int[][] grid, int row, int col) {
        Queue<Land> Q = new LinkedList<>();
        Q.offer(new Land(row,col));
        int area = 0;
        while (!Q.isEmpty()){
            area++;
            Land obj = Q.poll();
            int r = obj.I, c = obj.J;
            visited[r][c] = true;
            //UP
            if(r + 1 < grid.length && grid[r+1][c] == 1 && !visited[r+1][c]){
                Q.add(new Land(r+1,c));
                visited[r+1][c] = true;
            }
            //DOWN
            if(r - 1 > -1 && grid[r-1][c] == 1 && !visited[r-1][c]){
                Q.add(new Land(r-1,c));
                visited[r-1][c] = true;
            }
            //RIGHT
            if(c + 1 < grid[0].length && grid[r][c+1] == 1 && !visited[r][c+1]){
                Q.add(new Land(r,c+1));
                visited[r][c+1] = true;
            }
            //LEFT
            if(c - 1 > -1 && grid[r][c-1] == 1 && !visited[r][c-1]){
                Q.add(new Land(r,c-1));
                visited[r][c-1] = true;
            }
        }
        return area;
    }

    private static class Land{
        int I,J;
        private Land(int I, int J){
            this.I = I;
            this.J = J;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n,m;

        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<ArrayList<Integer> > a = new ArrayList<ArrayList<Integer> >();
        for(int i=0;i<n;i++){
            ArrayList<Integer> b = new ArrayList<>();

            for(int j = 0;j<m;j++){
                b.add(sc.nextInt());
            }
            a.add(b);
        }

        int ans = MaxAreaOfIsland.maxAreaOfIsland(a);
        System.out.println(ans);
    }

}
