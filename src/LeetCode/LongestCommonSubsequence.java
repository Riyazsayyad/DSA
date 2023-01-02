package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String a, String b) {
        short[][] mat = new short [1001][1001];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                mat[i+1][j+1] = (short) ((short) a.charAt(i) == b.charAt(j) ? mat[i][j] + 1 : Math.max(mat[i+1][j],mat[i][j+1]));
            }
        }
        return mat[a.length()][b.length()];
    }

}
