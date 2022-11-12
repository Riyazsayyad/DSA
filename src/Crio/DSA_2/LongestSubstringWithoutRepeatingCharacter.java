package Crio.DSA_2;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int high=0,low=0,max =0;
        Set<Character> set = new HashSet<>();
        int[] arr = new int[256];
        //aabcccbcb
        for(high=0,low=0;high<s.length();high++){
            if(!set.contains(s.charAt(high))){
                set.add(s.charAt(high));
                high++;
            }else{
                set.remove(s.charAt(low));
                low++;
            }
            max = Math.max(max,set.size());
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int result = new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
