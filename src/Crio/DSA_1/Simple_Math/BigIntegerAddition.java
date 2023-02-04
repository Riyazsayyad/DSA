package Crio.DSA_1.Simple_Math;

import java.util.*;

class BigIntegerAddition {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String num1 = "84481";
        String num2 = "987527893";

        String ans = bigIntegerAddition(num1, num2);
        System.out.println(ans);

    }

    // TODO: Implement this method
    static String bigIntegerAddition(String str1, String str2) {
        char[] strOne = str1.toCharArray();
        char[] strTwo = str2.toCharArray();
        ArrayList < Integer > ans = new ArrayList < Integer > ();

        int x = strOne.length;
        int y = strTwo.length;

        int sum = 0;
        int dec = 0;
        int carry = 0;
        String res = "";

        //Agar x bada ya equal hai
        if(x>=y){
            for(int i=1;i<=x;i++){
                if(i<=y){
                    sum = ((strOne[x - i] - '0') + (strTwo[y - i] - '0'))+carry;
                }
                else{
                    sum = (strOne[x-i]-'0')+carry;
                }
                dec = (sum % 10) ;
                carry = sum / 10;
                ans.add(dec % 10);
            }
        }


        //agar x chota hai
        else if(y>x){
            for(int i=1;i<=y;i++){
                if(i<=x){
                    sum = ((strOne[x - i] - '0') + (strTwo[y - i] - '0'))+carry;
                }
                else{
                    sum = (strTwo[y-i]-'0')+carry;
                }
                dec = (sum % 10) ;
                carry = sum / 10;
                ans.add(dec % 10);
            }
        }

        //arraylist > string>reverse
        for (int i=ans.size()-1;i>=0;i--){
            res += String.valueOf(ans.get(i));
        }
        return res;

    }
}