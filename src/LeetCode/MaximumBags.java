package LeetCode;
import java.util.*;
public class MaximumBags {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        /*
        Submitted Code -- did entire same thing but made diffrence arr instead sorted it so one with less diffrence comes first
        int n = rocks.length, count = 0;
        int[] diff = new int[n];
        for(int i = 0;i < n;i++) diff[i] = capacity[i] - rocks[i];

        Arrays.sort(diff);
        for(int i = 0;i < n;i++){
            if(diff[i] == 0) count++;
            else{
                if(additionalRocks >= diff[i]){
                    additionalRocks -= diff[i];
                    count++;
                }
            }
        }
        return count;
         */
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Math.abs(rocks[i1] - capacity[i1]) - Math.abs(rocks[i2] - capacity[i2]);
            }
        };

        Integer[] indices = new Integer[rocks.length];
        for (int i = 0; i < indices.length; i++) indices[i] = i;
        Arrays.sort(indices, comparator);

        int diff = 0, count = 0;
        for (int i: indices){
            diff = capacity[i] - rocks[i];
            if(rocks[i] != capacity[i] && additionalRocks - diff > -1){
                rocks[i] += diff;
                additionalRocks -= diff;
            }
            if(rocks[i] == capacity[i]) count++;
        }
        return count;
    }
}
