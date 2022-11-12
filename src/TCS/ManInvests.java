package TCS;
/*
A man invests a certain amount on monthly basis in a bank. He withdraws that money once in 4 years which is a leap year,
to make a big scale purchase .He starts next investment exactly 183 days after the purchase .
Initially, he makes a note of his purchase date Given the date(dd) and month(mm) of his purchase.
The task here is to help him find the date and month to start his investment.His next investment date is calculated from
the next day of his purchase.Display the date as on 183rd day.
 */

import java.util.*;

public class ManInvests {

    public void findMonth(String month, int date){
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int mI =0,sum =0,limit=0;
        for (int i = 0; i < 12; i++) {
            if(months[i].equals(month)) mI=i; }
        limit = 183-(days[mI]-date);
        mI++;
        if(mI==12) mI=0;
        while (sum+days[mI]<limit){
            sum+=days[mI];
            mI++;
            if(mI==12) mI=0;
        }
       System.out.print(months[mI]+" "+(limit-sum));

    }


    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        String month = sc.next();
        sc.nextLine();
        int date  = sc.nextInt();
        sc.close();
        ManInvests mi = new ManInvests();
        mi.findMonth(month,date);
    }
}
