package Crio.DSA_3.Hash;

import java.util.*;
class FirstUniqueInteger{
    public static int firstUniqueInteger(Vector<Integer> vec)
    {
        Map<Integer,Integer> map = new LinkedHashMap<>(); //to preserve insertion order use LinkedHashMap
        for (int i = 0; i < vec.size(); i++) {
            map.put(vec.get(i),map.getOrDefault(vec.get(i),0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1) return entry.getKey();
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Vector<Integer> vec=new Vector<Integer>();
        for(int i=0;i<n;i++)
            vec.add(sc.nextInt());
        System.out.println(firstUniqueInteger(vec));
    }
}
