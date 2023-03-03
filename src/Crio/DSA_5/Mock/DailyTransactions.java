package Crio.DSA_5.Mock;
import java.util.*;

class DailyTransactions {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> res = dailyTransactions(n, arr);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> dailyTransactions(int n, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,-1);
        long sum=0;
        int x =0,y=0,maxLen=0;
        int[] index = new int[2];
        for(int i=0;i<n;i++) {
            sum += arr[i];  // to calculate prefix sum
            if (map.containsKey(sum)) {
                x = map.get(sum);   y = i; //to get prev occurrence of the sum 'x' and current index 'y'
                maxLen = Math.max(y - x, maxLen);   //to store maxLen for getting the longest subarray
                if ((y - x) >= maxLen){  index[0] =x+1;  index[1] =y;   } // if array found having larger length than previous on store index
            } else map.put(sum, i); //if not present add sum
        }
        if(index[1]==0) ans.add(-1);
        else    for(int j=index[0];j<=index[1];j++) ans.add(arr[j]); //to put largest subarray elements into arraylist
        return ans;
    }
}
