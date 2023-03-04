package Crio.DSA_5.AdvanceDSA;
import java.util.*;

public class RectangleArea {

    public long findArea(int n, int[][] rectangles) {
        int maxX = 0,maxY = 0;
        for (int[] A : rectangles){
            maxX = Math.max(A[0],A[2]);
            maxY = Math.max(A[1],A[3]);
        }

        boolean[][] grid = new boolean[maxY+1][maxX+1];


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