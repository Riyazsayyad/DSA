package Crio.DSA_5.AdvanceDSA;
import java.util.*;

public class RectangleArea {

    public long findArea(int n, int[][] rectangles) {
        /*Nhi samj rha*/
        return 0;
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