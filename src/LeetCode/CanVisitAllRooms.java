package LeetCode;

import java.util.*;

public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        var arr = new int[n];
        for (int j = 0, key = 1; j < n - 1; j++, key ++) {
                int found = Collections.binarySearch(rooms.get(j),key);
                if(found >=0 ) return false;
        }
        return true;
    }
}
