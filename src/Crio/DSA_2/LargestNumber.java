package Crio.DSA_2;

import java.util.*;
import java.util.Scanner;

class LargestNumber {
    public  String largestNumber(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int a: nums) arr.add(a);
        arr.sort(MaxNum);
        StringBuilder ans = new StringBuilder();
        for(int x : arr){
            ans.append(String.valueOf(x));
        }
        return ans.toString();
    }
    public static Comparator<Integer> MaxNum = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            var s1 = String.valueOf(a);
            var s2 = String.valueOf(b);

            var s1s2 = s1 + s2;
            var s2s1 = s2 + s1;

            return s2s1.compareTo(s1s2);
        }
    };
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        String result = new LargestNumber().largestNumber(nums);

        System.out.println(result);
    }

}
