package Crio.DSA_2;
import java.util.*;
public class LargestSubarraySumZero {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> res = largestSubarraySumZero(n, arr);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> largestSubarraySumZero(int n, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,-1);
        long sum=0;
        int x =0,y=0,maxLen=0;
        int[] index = new int[2];
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];  // to calculate prefix sum
            if (map.containsKey(sum)) {
                x = map.get(sum);   y = i; //to get prev occurance of the sum 'x' and current index 'y'
                maxLen = Math.max(y - x, maxLen);   //to store maxLen for getting the longest subarray
                if ((y - x) >= maxLen){  index[0] =x+1;  index[1] =y;   } // if array found having larger length than previous on store index
                } else map.put(sum, i); //if not present add summ
            }
            if(index[1]==0) ans.add(-1);
            else    for(int j=index[0];j<=index[1];j++) ans.add(arr[j]); //to put largest subarray elements into arraylist
            return ans;
    }
}



       /*
        // Bull shit
        int sum =0, find =0, max =0;
        Deque<Integer> DQ = new LinkedList<Integer>();
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Deque> map = new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                if(map.get(sum).size()>max){
                    max = map.get(sum).size();
                    find = sum;
                }
                DQ.add(i);
                map.replace(sum,DQ);
            }
            else{
                DQ.add(i);
                map.put(sum,DQ);}
        }
        int i = (int) map.get(find).getFirst() + 1;
        int j = (int) map.get(find).getLast() ;
        for(int x=i;x<j;x++) ans.add(arr[x]);

        return ans;

         */