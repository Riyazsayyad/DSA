package Crio.DSA_2;
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
        while (Math.abs((Math.pow(mid,n))-x) >= 10e-6){
            if(Math.pow(mid,n) > x) high=  mid;
            else if(Math.pow(mid,n) == x) return (int)mid;
            else low=  mid;
            mid = (low+high)/2;
        }
        double check = mid * 1e3;
        if((int)check%10==9) {   return (int) Math.round(mid);}
        return (int)Math.floor(mid);
    }
}
