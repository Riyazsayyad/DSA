package Crio.DSA_3.Hash;

import java.util.*;

// Implement your solution here
class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> mapS = new HashMap<>();
        Map<Character,Integer> mapP = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        var pLength = p.length();
        var sLength = s.length();
        var sChararr = s.toCharArray();
        if(pLength>sLength) return ans;
        for(char chr : p.toCharArray())   mapP.put(chr,mapP.getOrDefault(chr,0)+1);
        for (int i = 0; i < pLength; i++) {
            mapS.put(s.charAt(i),mapS.getOrDefault(s.charAt(i),0)+1);
        }
        for (int j = pLength; j < sLength; j++) {
            if(mapP.equals(mapS))   ans.add(j-pLength);
            if(mapS.get(sChararr[j-pLength])==1) mapS.remove(sChararr[j-pLength]);
            else mapS.replace(sChararr[j-pLength],mapS.get(sChararr[j-pLength])-1);
            mapS.put(s.charAt(j),mapS.getOrDefault(s.charAt(j),0)+1);
        }
        if(mapP.equals(mapS))   ans.add(sLength-pLength);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[2];
        input = scanner.nextLine().split(" ");
        String s = input[0];
        String p = input[1];
        scanner.close();

        List<Integer> result = new FindAllAnagramsInAString().findAnagrams(s,p);
        System.out.println(result.size());
        for (Integer i = 0; i < result.size(); ++i) {
            System.out.printf("%d ", result.get(i));
        }
    }
}