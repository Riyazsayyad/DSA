package LeetCode.Contests;

import java.util.Arrays;

public class Maximum69Number {
    public static int maximum69Number (int num) {
        char[] a = (String.valueOf(num)).toCharArray();
        for(int i=0;i<a.length;i++){
            if(a[i]=='6'){
                a[i] = '9';
                String str = String.valueOf(a);
                return Integer.parseInt(str);
            }
        }
    return 0;
    }
    public static void main(String[] args){
        System.out.println(maximum69Number(9669));
    }
}
