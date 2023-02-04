package Crio.DSA_2.Binary_Search;
import java.util.*;
public class NthRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int x = sc.nextInt();
            int n = sc.nextInt();

            int ans = nthRoot(x, n);

            System.out.println(ans);
        }
    }

    static int nthRoot(int x, int n) {
        double low = 1;
        double high = x;
        double mid = (low+high)/2;
        while (Math.abs(high-low) >= 10e-6){ //(Math.pow(mid,n))-x
            if(Math.pow(mid,n) > x) high=  mid;
            else if(Math.pow(mid,n) == x) return (int)mid;
            else low=  mid;
            mid = (low+high)/2;
        }
        low+=10e-6;
        return (int)Math.floor(low);
    }
}
