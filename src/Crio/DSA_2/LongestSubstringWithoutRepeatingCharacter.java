package Crio.DSA_2;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int high=0,low=0,max =0;
        int[] arr = new int[256];
        Arrays.fill(arr,-1);
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        for(high=0,low=0;high<s.length();high++){
            low = Math.max(low,arr[s.charAt(high)]);
            System.out.print(low+"L "+high+"H "+s.charAt(low)+"\t\n");
            max = Math.max(max,high-low);
            arr[s.charAt(high)] = high;
            System.out.print(arr[s.charAt(high)]+"\t\n");
        }
        if(max == s.length()-1) return ++max;
        return max;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int result = new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
