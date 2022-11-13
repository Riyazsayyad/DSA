package TCS;

import java.util.Scanner;

public class faultyProgram {
    static String Result(String s) {
        String alphabets = "", specialCharacter = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                alphabets += s.charAt(i);
            } else if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                specialCharacter += s.charAt(i);
            }
        }
        return alphabets + specialCharacter;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(Result(s));
    }
}
