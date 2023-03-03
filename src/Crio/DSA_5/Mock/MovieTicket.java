package Crio.DSA_5.Mock;
import java.util.*;


class MovieTicket{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(movieTicket(n,array,k));
    }

    static int movieTicket(int n,int[] array,int k){
        int[] dp = new int[k+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int val = 1; val <= k; val++) {
            for (int book : array) {
                if (book <= val) {
                    int curRes = dp[val - book];
                    if (curRes != Integer.MAX_VALUE && curRes + 1 < dp[val]) dp[val] = curRes + 1;
                }
            }
        }
        return dp[k] == Integer.MAX_VALUE ? -1 : dp[k];
    }
}
