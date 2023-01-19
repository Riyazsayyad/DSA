package Crio.DSA_4.Recursion_and_Backtracking;
import java.util.*;

public class RobotInAGrid {

    // Implement your Solution Here
    Vector<String> robotInAGrid(int grid[][] , int n , int m) {
        Vector<String> result = new Vector<>();
        getPath(grid,0,0,n,m,result);
        return result;
    }

    private Vector<String>  getPath(int[][] grid, int row, int col,int n,int m,Vector<String> result) {

        if(row == n-1 && col == m-1){
            result.add((row+1)+" "+(col+1));
            return result;
        }

        if(isValid(grid,row,col,n,m)){
            result.add((row+1)+" "+(col+1));
            if(row+1 < n) return getPath(grid,row+1,col,n,m,result);
            if(col+1 < m) return getPath(grid,row,col+1,n,m,result);
        }

        return result;
    }

    private boolean isValid(int[][] grid, int row, int col,int n,int m) {
        // check right
        if(col + 1 < m && grid[row][col+1] != 1) return true;

        //check down
        if(row + 1< n && grid[row+1][col] != 1) return true;

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
