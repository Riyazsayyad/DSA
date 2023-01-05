package LeetCode;

import java.util.*;

public class FindMinArrowShots {
    public static int findMinArrowShots(int[][] points) {
        //Arrays.sort(points,Comparator.comparingInt(a -> a[1])); // fast
        //Arrays.sort(points,(a,b) -> a[1] - b[1]); // faster
        //fastest, as it internally uses multiple cores | 25% -> 82.36%
        Arrays.parallelSort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int last = points[0][1],count = 1;
        for (int j = 1; j < points.length ; j++) {
            if(points[j][0] > last){
                last = points[j][1];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }
}

