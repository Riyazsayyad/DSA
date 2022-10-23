package Crio.DSA_1;

import java.util.Scanner;

public class SeriesSumI {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 9;

        int result = seriesSumI(n);

        System.out.println(result);
        System.out.println(1131);

    }

    // TODO: Implement this method
    static int seriesSumI(int n) {
        int sum=0;
        int count=0;
        for(int i=1;count<n;i+=2){
            sum+=i*(i+2);
            count++;
        }
        return  sum;
    }
}
