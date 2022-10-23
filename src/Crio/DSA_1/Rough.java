package Crio.DSA_1;

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



    }
}