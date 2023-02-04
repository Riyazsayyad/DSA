package Crio.DSA_1.Simple_DS;

import java.util.Scanner;

public class ModularExponentiation {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = 100000000 ;
        int n = 2;

        int ans = modularExponentiation(x, n);
        System.out.println(ans);
    }

    // TODO: Implement this method
//    static int Power(int x, int n) {
//        if (n == 0)
//            return 1;
//        if (n % 2 == 1)
//            return x * Power(x * x, n / 2);
//        else
//            return Power(x * x, n / 2);
//    }
    //930000007
    //874919417

    static int modularExponentiation(int x, int n) {
        long mod =  (long)Math.pow(10,9)+7;
        //System.out.println(mod);
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return (int) (x%mod * modularExponentiation((int) ((x%mod * x%mod)%mod), n / 2));
        else
            return modularExponentiation((int) ((x%mod * x%mod)%mod), n / 2);
    }



//        double mod = Math.pow(10,9);
//        if(n==0)
//            return 1;
//        double v = (x % mod * x % mod) % mod;
//        System.out.println(v);
//
//        if(n%2==0)
//            return modularExponentiation((long) v,n/2);
//        else
//            return ((long)(x%mod*modularExponentiation((long) v,n/2)));



}
