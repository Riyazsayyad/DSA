package TCS;
import java.io.*;
import java.util.*;
public class CardsDummy {
    public static int cards(int input1, int[] input2) {
        int maxI=0,nMax=0,sum1=0,sum2=0;
        int[] ans0 = Arrays.copyOf(input2,input1);
        for (int i = 0; i < input1; i++) {
            if(input2[i]<0 && Math.abs(input2[i])>nMax){
                    maxI=i;
                    nMax = Math.abs(input2[i]); }
        }
        for (int j = 0; j < input1-1; j++) {
            if(ans0[j]<0 && ans0[j+1]<0){
                while (ans0[j]<0){
                    ans0[j]=Math.abs(ans0[j]);
                    ++j;
                    if(j==input1)   break;
                }
            }
        }
        for(int a: ans0) sum1+=a;
        input2[maxI] = Math.abs(input2[maxI]);
        for (int k = 0; k < input1; k++) {
            sum2+=input2[k];
        }
        return Math.max(sum1,sum2);
    }

    public static void main(String[] args){
        int n = 5;
        int[] arr = {-1,2,3,4,-5};
        int[] arr1 = {-2,3,-1,-4,-2};
        int[] arr2 = {-2,-3,-1,-4,-2};
        System.out.println(cards(n,arr));
        System.out.println(cards(n,arr1));
        System.out.println(cards(n,arr2));
    }
}
