package Crio.DSA_5.Mock;

import java.util.*;


class BirthdayParty{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int [] ans = birthdayParty(arr, n);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
    }

    static int [] birthdayParty(int arr[], int n){
        // needs to be optimized
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                if(arr[i] > arr[j]){
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }


}
