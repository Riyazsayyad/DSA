package Crio.DSA_2;
import java.util.*;
public class WiggleSort {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        List<Integer>ans = wiggleSort(n,nums);
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i)+" ");
        }
    }

    static List<Integer> wiggleSort(int n, List<Integer>nums){

        // Works fine for crio
        Collections.sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0,j = nums.size()/2,k=0;
        if(nums.size()%2!=0)    ++j;
        while (j<nums.size()){
            ans.add(k++,nums.get(i)); //min
            ans.add(k++,nums.get(j)); //max
            i++; j++;
            }
        if(nums.size()%2!=0)   ans.add(k,nums.get(i));
        return  ans;
    }
}
