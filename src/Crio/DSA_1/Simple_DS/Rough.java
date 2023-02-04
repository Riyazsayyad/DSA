package Crio.DSA_1.Simple_DS;

import java.util.*;
public class Rough{
    public static void main(String[] args){
        int n = (int) Math.pow(2,(5))-1;
        System.out.println(n);
        TreeNode root = new TreeNode(0);
        Queue<Integer> q = new LinkedList<Integer>();
        int [] arr ={-1,0,1,2,-1,-4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(0);
        Stack<Character> stack = new Stack<Character>();
        stack.peek();
        Map<Character,Integer> map = new HashMap<>();
        map.keySet();
        ArrayList<int[]> store = new ArrayList<>();
        int [] a = new int[0];
        a[0]=1;
        store.isEmpty();
        store.add(a);
        Iterator<int[]> iter = store.iterator();
        System.out.println(store.get(0)[1]);
        String s = "ssdad";
        String word1= "ssdad",  word2= "ssdad";
        char[] word1Arr = (word1.toCharArray());
        char[] word2Arr = (word2.toCharArray());
        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);


    }
}