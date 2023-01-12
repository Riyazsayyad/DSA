package Crio.DSA_4.Recursion_and_Backtracking;

import java.io.*;
import java.util.*;
import java.lang.*;

public class LetterCombinationsOfPhoneNumber {
    private HashMap<Integer,String> map = new HashMap<>();
    public List<String> letterCombinationsOfPhoneNumber(String digits) {

        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        ArrayList<String> result = new ArrayList<>();
        getCombi(result,digits,0,"");
        return result;
    }
    // 23
    //ad ae af bd be bf cd ce cf
    /*
                                                    (getCombi)
                                                   /    |    \
                                              (index=2) (index=2) (index=2)
                                              /    |    \
                                         (index=1) (index=1) (index=1)
                                         /    |    \
                                    (index=0) (index=0) (index=0)

     */
    private void getCombi(ArrayList<String> res,String digit,int index,String ans){
        if(index == digit.length()){
            res.add(ans);
            return;
        }
        char ch = digit.charAt(index);
        for(int i = 0; i < map.get(ch-'0').length();i++){
            char t = map.get(ch-'0').charAt(i);
            getCombi(res,digit,index+1,ans+t);
        }
    }





    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        List<String> combinations = new LetterCombinationsOfPhoneNumber().letterCombinationsOfPhoneNumber(line);
        for (String cmbn : combinations)
            System.out.print(cmbn + " ");
    }
}
