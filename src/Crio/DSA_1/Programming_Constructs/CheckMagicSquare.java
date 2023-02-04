package Crio.DSA_1.Programming_Constructs;
import java.util.*;
class CheckMagicSquare {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int grid[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        }

        String result = checkMagicSquare(n, grid);

        System.out.println(result);

    }

    // TODO: Implement this method
    static String checkMagicSquare(int n, int[][] grid) {
        int sumAll=0;
        int sumC=0;
        int sumR=0;
        int val1=0;
        int sumP=0;
        int sumA=0;
        for(int a=0;a<n;a++){
            //diagonal check
            sumP+=grid[a][a];
            sumA+=(grid[a][n-1-a]);
            for(int b=0;b<n;b++){
                //row and column check
                sumC +=grid[b][a];
                sumR +=grid[a][b];
            }
            boolean dec0 = sumC ==  sumR;

            sumC =0;
            sumR =0;
            if (dec0){}
            else{
                return "No";
            }
        }
        boolean dec1 = sumP == sumA;

        if(dec1){
            return "Yes";
        }
        else{
            return "No";
        }



    }
}
