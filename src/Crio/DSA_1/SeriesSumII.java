package Crio.DSA_1;

import java.util.Scanner;

public class SeriesSumII {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double A = 1;
        double R = 0.5;

        double result = seriesSumII(A, R);

        System.out.println(result);
    }

    // TODO: Implement this method
    static double seriesSumII(double A, double R) {
        double num= A/(1-R);


        return num;

    }
}
