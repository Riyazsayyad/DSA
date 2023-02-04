package Crio.DSA_1.Simple_DS;

import java.util.*;
import java.util.Iterator;

public class The_Comparator implements Comparator<Integer> {
    public int compare(Integer str1, Integer str2)
    {
        Integer first;
        Integer second;
        first = str1;
        second = str2;
        return second.compareTo(first);
    }
}
public class DataStructure{
    public static void main(String[] args){


        //Arrays.so

        PriorityQueue<Integer> ass = new PriorityQueue<Integer>(new The_Comparator());
        ass.add(1);
        ass.add(3);
        ass.add(2);

        Iterator iter = ass.iterator();

        System.out.print(ass.peek());
        // Creating a comparator

    }


}
