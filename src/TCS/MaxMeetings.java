package TCS;

import java.util.*;

public class MaxMeetings {
    public static void possibleMeetings(int[] start ,int [] end, int n){
        int count =0;
        int res = end[0];
        for (int i = 1; i < n-1; i++) {
            if(res<=start[i]){
                res = end[i];
                count++;
            }
        }
    System.out.print(count);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int [] x = new int[a];
        int [] y = new int[b];
        sc.nextLine();
        for (int i = 0; i < a; i++) {
            x[i] = sc.nextInt();
        }
        for (int j = 0; j < b; j++) {
            x[j] = sc.nextInt();
        }
        sc.close();
        possibleMeetings(x,y,a);
    }
}
