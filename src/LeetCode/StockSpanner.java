package LeetCode;


import java.util.*;
public class StockSpanner {
    ArrayList<Integer> store = new ArrayList<>();
    public StockSpanner() {
        // previous value store krne k liye array banauga price aur span daluga
        //pehle check kruga ki current input k upr ktte chote hai  while loop se

    }
    public static void main(String[] args){
        StockSpanner stockSpanner = new StockSpanner();
        System.out.print(stockSpanner.next(31)+" ");
        System.out.print(stockSpanner.next(41)+" ");
        System.out.print(stockSpanner.next(48)+" ");
        System.out.print(stockSpanner.next(59)+" ");
        System.out.print(stockSpanner.next(79)+" ");
        //System.out.print(stockSpanner.next(75)+" ");
        //System.out.print(stockSpanner.next(85)+" ");

    }
//    Stack<int[]> stack = new Stack<>();
//    public int next(int price) {
//        int res = 1;
//        while (!stack.isEmpty() && stack.peek()[0] <= price)
//            res += stack.pop()[1];
//        stack.push(new int[]{price, res});
//        return res;
//    }
    public int next(int price) {
        int span=1;
        if(store.isEmpty()){store.add(price);}
        int i =1;
        while (store.get(store.size()-i)<=price && i<store.size()-1){i++;span++;}
        store.add(store.size(),price);
        return span;
    }
}
