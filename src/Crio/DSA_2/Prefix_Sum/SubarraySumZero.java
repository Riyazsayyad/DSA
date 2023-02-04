package Crio.DSA_2.Prefix_Sum;
import java.util.*;

public class SubarraySumZero {
    public static String subarraySumZero(Vector<Integer> arr)
    {
        Set<Integer> prefixSet = new HashSet<Integer>();
        int sum=0;
        System.out.println(arr);
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
            if(prefixSet.contains(sum) || arr.get(i)==0 || sum==0) return "Yes";
            prefixSet.add(sum);
        }
        return "No";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++)
        {
            int n=sc.nextInt();
            Vector<Integer> arr=new Vector<Integer>();
            for(int i=0;i<n;i++)
            {
                arr.add(sc.nextInt());
            }
            System.out.println(subarraySumZero(arr));
        }

    }
}
