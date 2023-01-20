package Crio.DSA_4.Greedy_Algo;

import java.util.*;

public class CircularRace {
    static int circularRace(int n, ArrayList<Integer>gas, ArrayList<Integer>burn){
        int start = 0,end = 1, curr = gas.get(0) - burn.get(0);
        if(n == 1) return 1;
        while (start != end){
            while (curr < 0 && start != end){
                curr -= (gas.get(start) - burn.get(start));
                start = (start + 1) % n;

                if(start == 0) return -1;
            }
            curr += gas.get(end)- burn.get(end);
            end = (end + 1) % n;
        }
        return curr < 0 ? -1 : ++start; //0 based index hai so ++start
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ;
        ArrayList<Integer>gas = new ArrayList<Integer>();
        ArrayList<Integer>burn = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            gas.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            burn.add(sc.nextInt());
        }
        int ans = circularRace(n,gas,burn);
        System.out.print(ans);
        sc.close();
    }
}

