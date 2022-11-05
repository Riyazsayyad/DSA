package Crio.DSA_2;

import java.util.*;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int res = removeDuplicatesFromSortedArrayII(n, arr);

        System.out.println(res);

        for (int i = 0; i < res; i++)
            System.out.print(arr[i] + " ");

    }
//    int removeDuplicates(vector<int>& nums) {
//        int i = 0;
//        for (int n : nums)
//            if (i < 2 || n > nums[i-2])
//                nums[i++] = n;
//        return i;
//    }
    static int removeDuplicatesFromSortedArrayII(int n, int[] arr) {
        int i=0;
        for(int a:arr){
            if(i<2 || a > arr[i-2]) arr[i++]=a;
        }
        return i;
        /*
        ArrayList<Integer> aL = new ArrayList<Integer>();
        for(int i=0;i<n-1;i++){
            int cnt =0;
            aL.add(arr[i]);
            while (arr[i]==arr[i+1] && i<n){
                i++;
                cnt++;
                aL.add(arr[i]);
                if (cnt>1)  arr[i]=0;
            }cnt=0;aL.add(arr[i]);

        }
        System.out.println(Arrays.asList(aL));
        return arr.length;
        */
    }
}
