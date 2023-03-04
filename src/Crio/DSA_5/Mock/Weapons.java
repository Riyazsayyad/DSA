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

    static int weapons(int n, int P, int[] weapon){
        Arrays.sort(weapon);
        int i = 0,j = n - 1,rating = 0,result = 0;
        while (i <= j){
            if(weapon[i] <= P){
                P -= weapon[i++];
                rating++;
            }
            else if(rating > 0){
                P += weapon[j--];
                rating--;
            }
            else break;
            result = Math.max(rating,result);
        }
        return result;
    }
}
