package Crio.DSA_2.Two_Pointers;
 import java.util.*;
public class MoveZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Vector<Integer> vec = new Vector<Integer>();
        for(int i=0;i<n;i++)
            vec.add(sc.nextInt());
        Vector<Integer> res = moveZeroes(vec);
        for(Integer elem : res)
            System.out.print(elem+" ");
    }
    private static Vector<Integer> moveZeroes(Vector<Integer> vec){
        int count=0;
        Vector<Integer> temp = new Vector<>();
        for (Integer integer : vec) {
            if (integer == 0)   count++;
            else   temp.add(integer);
        }
        for (int i = 0; i < count; i++) temp.add(0);
        return temp;
    }
}
