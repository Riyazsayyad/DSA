package Striver_SDE_Sheet.Day_2;
import java.util.*;
public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.parallelSort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merge = new LinkedList<>();

        for(int[] interval : intervals){
            if(merge.isEmpty() || merge.getLast()[1] < interval[0]) merge.add(interval);
            else merge.getLast()[1] = Math.max(merge.getLast()[1],interval[1]);
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
