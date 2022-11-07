package Crio.DSA_2;

import java.util.*;

public class MergeIntervals {
    public int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int n = ans.size();
            if (ans.get(n - 1)[1] >= intervals[i][0]) {
                ans.get(n - 1)[1] = Math.max(ans.get(n - 1)[1], intervals[i][1]);
            } else ans.add(intervals[i]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
        /*
        int n = intervals.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            int prevI = i - 1;
            if (intervals[i][0] <= intervals[i - 1][1]) {
                while (intervals[i][0] <= intervals[i - 1][1]  && i<n-1 ) {
                    i++;
                }
                stack.add(intervals[prevI][0]);
                if(i==n-1)  stack.add(intervals[i][1]);
                else stack.add(intervals[i - 1][1]);

            } else {
                    stack.add(intervals[prevI][0]);
                    stack.add(intervals[prevI][1]);
                    if(i==n-1){
                        stack.add(intervals[i][0]);
                        stack.add(intervals[i][1]);}
                    }
            }
            System.out.println(Arrays.asList(stack)+" "+stack.size());
            int x = stack.size()/2;
            int [][] ans = new int[x][2];
            for(int a =x-1;a>-1;a--){
                ans[a][1] = stack.pop();
                ans[a][0] = stack.pop();
            }
            return ans;
            */
        /*
        //Crio Solution
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merge = new LinkedList<>();

        for(int[] interval : intervals){
            if(merge.isEmpty() || merge.getLast()[1] < interval[0]){
                merge.add(interval);
            }else {
                merge.getLast()[1] = Math.max(merge.getLast()[1],interval[1]);
            }
        }
        return merge.toArray(new int[merge.size()][]);

         */


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nums = new int[n][2];

        for(int i = 0 ; i < n ;i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        int[][] results = new MergeIntervals().mergeIntervals(nums);

        for (int i = 0; i < results.length; ++i) {
            System.out.printf("%d %d\n", results[i][0], results[i][1]);
        }
    }
}
