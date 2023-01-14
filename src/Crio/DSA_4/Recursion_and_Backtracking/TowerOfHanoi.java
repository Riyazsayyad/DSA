package Crio.DSA_4.Recursion_and_Backtracking;

import java.util.*;

public class TowerOfHanoi {
    // Implement your solution here
    ArrayList<String> result = new ArrayList<>();
    int count = 0;
    //(plates. no., source, destination, helper)
    private void transfer(int n, char source, char destination, char helper){
        if(n == 1){
            result.add(1+" "+source+" "+destination);
            //System.out.println((count++)+" "+source+" "+destination+" "+helper+" "+n);
            return;
        }
        transfer(n-1,source,helper,destination);
        result.add(n+" "+source+" "+destination);
        //System.out.println((count++)+" "+source+" "+destination+" "+helper+" "+n);
        transfer(n-1,helper,destination,source);
    }
    ArrayList<String> towerOfHanoi(int n) {
        transfer(n,'A','C','B');
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> result = new TowerOfHanoi().towerOfHanoi(n);
        for(int i = 0 ; i < result.size() ; i++) {
            System.out.println(result.get(i));
        }
    }
}
