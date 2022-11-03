package Crio.DSA_2;
import java.util.*;

public class ReverseWordsInAString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseWordsInAString(s));
        sc.close();
    }

    static String reverseWordsInAString(String s){
        String res ="";
        int n = s.length();
        int i=0;
        char [] a = s.toCharArray();
        while(i<n){
            while(i<n && a[i]==' ')    i++;
            if(i>=n) break; //if str is empty

            int j=i;
            while(j<n && a[j]!=' ') j++;
            String sub=s.substring(i,j);

            if(res.length()==0) res = sub;
            else    res = sub+" "+res;

            i=j+1;
        }
        return res;
    }
}
