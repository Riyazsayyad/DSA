package LeetCode;
import java.util.*;
public class CanCompleteCircuit {
    private boolean driveCircle(int j, int[] gas,int[] cost,int n){
        int tank = gas[j],i = j + 1,count = 0;

        while (count != n){
            tank = tank - cost[j % n] + gas[i % n];
            //System.out.println(j+" "+i);
            if(tank < gas[i % n]) return false;
            i++; j++;
            count++;
        }
        return true;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i = 0;i < n;i++){
            if(gas[i] >= cost[i]){
                if(driveCircle(i,gas,cost,n)) return i;
            }
        }
        return -1;
    }
}
