package Crio.DSA_5.AdvanceDSA;
import java.util.*;

public class RectangleArea {

    private boolean[][] grid;
    private boolean[][] visited;
    private int result;
    public long findArea(int n, int[][] rectangles) {
        int maxX = 0,maxY = 0;
        result = 0;
        for (int[] A : rectangles){
            maxX = Math.max(maxX,Math.max(A[0],A[2]));
            maxY = Math.max(maxY,Math.max(A[1],A[3]));
        }

        grid = new boolean[maxY+1][maxX+1];
        visited = new boolean[maxY+1][maxX+1];

        for (int[] A: rectangles){
            fillArea(A[0],A[1],A[2],A[3]);
        }

        dfs(0,0);

        return result;
    }

    private void dfs(int x,int y) {
        System.out.println("HI");
        int N = visited.length;
        if(x < N && y < N && x >= 0 && y >= 0 && !visited[x][y] && grid[x][y]){
            visited[x][y] = true;
            result++;
            dfs(x+1,y);
            dfs(x-1,y);
            dfs(x,y+1);
            dfs(x,y-1);
        }
    }

    private void fillArea(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            Arrays.fill(grid[i],x1,x2,true);
        }
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] rectangles = new int[n][4];

        for(int i = 0 ; i < n ;i++) {
            rectangles[i][0] = scanner.nextInt();
            rectangles[i][1] = scanner.nextInt();
            rectangles[i][2] = scanner.nextInt();
            rectangles[i][3] = scanner.nextInt();
        }
        scanner.close();

        long result = new RectangleArea().findArea(n, rectangles);
        System.out.print(result);
    }
}