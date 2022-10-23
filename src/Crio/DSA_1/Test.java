package Crio.DSA_1;

import java.util.ArrayList;

public class Test {
    public static String bigAdd(String s1, String s2) {
        int x = s1.length(); //One
        int y = s2.length(); //Two
        System.out.println(x + " " + y);

        char[] strOne = s1.toCharArray();
        char[] strTwo = s2.toCharArray();
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        int carry = 0;
        int sum = 0;
        int dec = 0;
        if (x >= y)
            for (int i = 1; i <= x; i++)
                if (i <= y) {
                    sum = ((strOne[x - i] - '0') + (strTwo[y - i] - '0'))+carry;
                    dec = (sum % 10) ;
                    carry = sum / 10;
                    ans.add(dec % 10);

                    System.out.println("One " + (strOne[x - i] - '0') + " Two " + (strTwo[y - i] - '0') + " Sum " + sum + " Dec " + dec + " Carry " + carry);
                }
                else {
                    if (i>=x)
                        System.out.println(strOne);
                        sum = (strOne[x-i]-'0')+carry;
                        dec = (sum % 10) ;
                        carry = sum / 10;
                        ans.add(dec%10);
                }
        else
            for (int i = 1; i <= y; i++)
                if (i <= x) {
                    sum = ((strOne[x - i] - '0') + (strTwo[y - i] - '0'))+carry;
                    dec = (sum % 10) ;
                    carry = sum / 10;
                    ans.add(dec % 10);

                    System.out.println("One " + (strOne[x - i] - '0') + " Two " + (strTwo[y - i] - '0') + " Sum " + sum + " Dec " + dec + " Carry " + carry);
                }
                else {
                    if (i>=y)
                        System.out.println(strTwo);
                        sum = (strTwo[y-i]-'0')+carry;
                        dec = (sum % 10) ;
                        carry = sum / 10;
                        ans.add(dec%10);
                }

        String f = "";
        for (int i=ans.size()-1;i>=0;i--)
            f += String.valueOf(ans.get(i));
        System.out.println(ans);
        return f;
    }

    public static void main(String[] args) {
        //6123519184948711 80494019977490432571710
        //987612374
        String s1 = "987527893 ";
        String s2 = "84481";
        System.out.println(bigAdd(s1, s2));
    }
}