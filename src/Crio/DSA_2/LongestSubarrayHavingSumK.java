package Crio.DSA_2;
import java.util.*;
public class LongestSubarrayHavingSumK {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(longestSubarrayHavingSumK(n,k,arr));
    }

    static int longestSubarrayHavingSumK(int n, int k, int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0, maxlen=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            if(sum == k) maxlen= i+1;
            if(!map.containsKey(sum)) map.put(sum,i);
            if(map.containsKey(sum-k))  maxlen = Math.max(i-map.get(sum-k),maxlen);
            System.out.println(i);
        }

        return maxlen;
        /* by using sliding window approach:
        *   if we find the sum ==k then increse low
        * nhi  too increase high
        * maxlen high - low aur max ko store kjaro
        *   FAILED APPROACH
        * */
        /*
        int low=0, high=0, sum=0,maxlen=0;
        for(low=0,high=0;high<n;high++){
            while ( sum!=k && high<n || arr[--high]==k){
                sum+=arr[high];
                high++;
            }
            sum-=arr[low];
            maxlen=Math.max(maxlen,((high)-low));
            low++; high++;
        }
        return maxlen;
        */
    }
}
