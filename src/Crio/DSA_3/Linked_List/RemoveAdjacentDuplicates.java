package Crio.DSA_3.Linked_List;
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
        Deque<Character> q = new LinkedList<>();
        boolean flag = true;
        for(char a: s.toCharArray()){
            if(q.isEmpty()) q.offer(a);
            else{
                if(q.getLast()==a){
                    q.pollLast();
                    flag=false;
                }
                else q.offer(a);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char x: q) ans.append(x);
        if(flag) return ans.toString();
        else return removeAdjacentDuplicates(ans.toString());
    }
}
