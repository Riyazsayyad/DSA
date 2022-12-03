package Crio.DSA_3;

import java.util.*;

class FrequentWords{
    public static Vector<String> frequentWords(Vector<String> vec,int k)
    {
        Vector<String> ans = new Vector<>();
        if(vec.size()<k) return ans;
        Map<String,Integer> map = new HashMap<>();
        for(String word : vec){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                 if(!o2.getValue().equals(o1.getValue())) return o2.getValue().compareTo(o1.getValue());
                 else return o1.getKey().compareTo(o2.getKey());
            }
        });
        //System.out.println(list.toString());
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i).getKey());
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Vector<String> vec=new Vector<String>();
        for(int i=0;i<n;i++)
            vec.add(sc.next());
        int k=sc.nextInt();
        Vector<String> ans = frequentWords(vec, k);
        for(int i=0;i<k;i++)
            System.out.println(ans.get(i));
    }
}