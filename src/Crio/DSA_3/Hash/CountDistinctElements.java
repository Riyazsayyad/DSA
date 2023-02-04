package Crio.DSA_3.Hash;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

class CountDistinctElements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> res = countDistinctElements(n, b, arr);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> countDistinctElements(int N, int B, int arr[]) {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(B>N) return ans;
        for (int i = 0; i < B; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        ans.add(map.size());
        for (int j = B; j < N; j++) {
            if(map.get(arr[j-B])==1) map.remove(arr[j-B]);
            else map.replace(arr[j-B],map.get(arr[j-B])-1);
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            ans.add(map.size());
        }
        return ans;
    }
}
