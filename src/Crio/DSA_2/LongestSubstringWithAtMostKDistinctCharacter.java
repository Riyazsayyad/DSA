package Crio.DSA_2;
import java.util.*;
public class LongestSubstringWithAtMostKDistinctCharacter {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int h=0,l=0;
        int x=0,y=0, maxLen=0;
        int[] freq = new int[256];
        Set<Integer> set = new HashSet<>();
        if (k==0) return 0;
        for(l=0,h=0;h<s.length();h++){
            set.add((int)s.charAt(h));
            freq[(int)s.charAt(h)]++;

            while (set.size()>k){
                if(--freq[s.charAt(l)]==0){
                    set.remove((int)s.charAt(l));
                }
                l++;
            }
            maxLen = Math.max(h - l, maxLen);
        }
        return ++maxLen;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        scanner.close();

        int result = new LongestSubstringWithAtMostKDistinctCharacter().lengthOfLongestSubstringKDistinct(s,k);
        System.out.println(result);
    }
}
