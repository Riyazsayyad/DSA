package Crio.DSA_1;

public class StringPermutation {

    static void printPermutn(String str, String ans)
    {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String res = str.substring(0, i) + str.substring(i + 1);
            printPermutn(res, ans + ch);
        }
    }


    public static void main(String[] args)
    {
        String s = "abc";
        printPermutn(s, "");
    }
}
