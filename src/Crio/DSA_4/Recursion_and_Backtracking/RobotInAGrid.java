package Crio.DSA_4.Recursion_and_Backtracking;
import java.util.*;

public class RobotInAGrid {

    // Implement your Solution Here
    boolean visited[][];
    Vector<String> robotInAGrid(int grid[][] , int n , int m) {
        Vector<String> result = new Vector<>();
        visited = new boolean[n][m];
        if(getPath(grid,0,0,n,m,result) && grid[n-1][m-1] != 1){
            return correctedSeq(result,n,m);
        }
        else{
            result.clear();
            result.add("Not Possible");
            return result;
        }


    }

    private Vector<String> correctedSeq(Vector<String> result,int n,int m) {
        Vector<String> ans = new Vector<>();
        for (int i = result.size()-1; i > -1; i--) {
            ans.add(result.get(i));
        }
        ans.add(n+" "+m);
        return ans;
    }

    private boolean  getPath(int[][] grid, int row, int col,int n,int m,Vector<String> result) {
        if(row == n-1 && col == m-1 ) return true;
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 1 || visited[row][col]) return false;
        visited[row][col] = true;

        if (getPath(grid, row + 1, col, n, m, result) || getPath(grid, row, col + 1, n, m, result)) {
            result.add((row + 1) + " " + (col + 1));
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int grid[][] = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        RobotInAGrid answer = new RobotInAGrid();
        Vector<String> result = answer.robotInAGrid(grid , n , m);
        for(String elem : result)
        {
            System.out.println(elem);
        }
    }
}
