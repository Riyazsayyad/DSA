package Crio.DSA_3;
import java.util.*;
class RemoveAdjacentDuplicates{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String result = removeAdjacentDuplicates(s);
        System.out.println(result);

        sc.close();
    }

    static String removeAdjacentDuplicates(String s){
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)==2) map.remove(c);
        }
        StringBuilder ans = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            ans.append(entry.getKey());
        }
        return ans.toString();
    }
}
