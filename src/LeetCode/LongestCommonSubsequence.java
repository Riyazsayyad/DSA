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

    /*
    // DP solution in C++ ; trying to implement Black Box
    int longestCommonSubsequence(string &a, string &b) {
        short m[1001][1001] = {};
        for (auto i = 0; i < a.size(); ++i)
            for (auto j = 0; j < b.size(); ++j)
                m[i + 1][j + 1] = a[i] == b[j] ? m[i][j] + 1 : max(m[i + 1][j], m[i][j + 1]);
        return m[a.size()][b.size()];
    }
    */
    /*
    public static int findCount(char[] big, char[] small){
        int n = small.length, count = 0;
        for (int i = 0,j = 0; i < big.length; i++) {
            if(big[i] == small[j%n]) {
                count++;
                j++;
            }
        }
        return count;
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() > text2.length()) return findCount(text1.toCharArray(),text2.toCharArray());
        else return findCount(text2.toCharArray(),text1.toCharArray());
    }

    public static void main(String[] args) {
        int res = longestCommonSubsequence("lb","alb");
        System.out.println(res);
    }

 */
}
