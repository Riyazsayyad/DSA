package Crio.DSA_2;
import java.util.*;
public class NextGreaterElementWithSameSetOfDigits {
    public static void main(String args[]){
        int n = 536723123;
        System.out.print(nextGreaterElementWithSameSetOfDigits(n));
    }

    static int nextGreaterElementWithSameSetOfDigits(int n){
        ArrayList<Integer> sack = new ArrayList<>();
        boolean flag = true;
        int ans =0, dec =1, z =0;
        int min =Integer.MAX_VALUE, prevI=0, curI =0;
        while (n!=0){
            sack.add(0,n%10);
            n=n/10;
        }
        // 534976
        for (int i = 1; i < sack.size(); i++) {
            if(sack.get(i-1) < sack.get(i)){
                prevI = i;
                flag = false;
                while (i+1 < sack.size()){
                    if(min > sack.get(i+1) && min > sack.get(prevI)) {
                        min = sack.get(i+1) ;
                        curI = i+1;
                    }i++;
                }
                Collections.swap(sack,prevI,curI);
                int[] sack1 = new int[sack.size()];
                for (int j = 0; j < sack.size(); j++) sack1[j] = sack.get(j);
                Arrays.sort(sack1,++prevI,sack1.length);
                dec = sack1.length-1;
                for (int j = 0; j < sack1.length; j++,dec--)    ans+=sack1[j]*Math.pow(10,dec);
            }else continue;
        }
        if(flag) return -1;
        return ans;
    }

}
