package LeetCode;

import java.util.Arrays;

public class MinimumRounds {
    public int minimumRounds(int[] tasks) {
        int count  = 0,ans = 0,n = tasks.length;
        Arrays.sort(tasks);
        for (int i = 0; i < n; i++) {
            count++;
            if(i == n-1 || tasks[i] != tasks[i+1]){
                if(count == 1) return -1;
                ans += count/3;
                if(count % 3 != 0) ans++;
                count = 0;
            }
        }
        return ans;
    }
}
