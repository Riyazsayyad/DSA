package Crio.DSA_5.Mock;
import java.util.*;


public class Weapons{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),P = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println(weapons(n,P,arr));
    }

    static int rating;
    static int[] dp;
    static int weapons(int n, int P, int[] weapon){
        rating = 0;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return maxRating(weapon,P,n);
    }

    private static int maxRating(int[] weapon, int power, int n) {
        if (n == 0 || power < 0) return 0;
        if(dp[n] != -1) return dp[n];
        rating = Math.max(
                     maxRating(weapon,power - weapon[n-1],n-1) + 1,
                     maxRating(weapon,power + weapon[n-1],n-1) - 1
        );
         return rating;
    }
}
