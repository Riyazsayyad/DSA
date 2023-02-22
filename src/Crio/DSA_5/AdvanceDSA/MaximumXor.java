package Crio.DSA_5.AdvanceDSA;
import java.util.*;

public class MaximumXor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }
        int ans = maximumXor(n,a);
        System.out.println(ans);
        sc.close();
    }
    // Implement Your Solution Here
    public static int maximumXor(int n,ArrayList<Integer> a){
        TrieMX obj = new TrieMX();
        return obj.findMaxXORPair(a);
    }
}


class TrieNodeMX {
    TrieNodeMX[] children;
    public TrieNodeMX(){
        children = new TrieNodeMX[32];
    }
}

class TrieMX {
    private TrieNodeMX root;

    public TrieMX() {
        root = new TrieNodeMX();
    }

    public void insert(int val) {
        TrieNodeMX current = root;
        for (int i = 31; i > -1; i--) {
            int bit = 0;
            if ((val & (1 << i)) > 0) bit = 1;
            if (current.children[bit] == null) {
                current.children[bit] = new TrieNodeMX();
            }
            current = current.children[bit];
        }
    }

    public int findMaxXORPair(ArrayList<Integer> A) {
        int ans = 0;
        for (int val : A){
            ans = Math.max(ans,findMaxXOR(val));
            insert(val);
        }
        return ans;
    }

    private int findMaxXOR(int val) {
        TrieNodeMX current = root;
        int ans = 0;
        for (int i = 31; i > -1; i--) {
            int bit = 0;
            if ((val & (1 << i)) > 0) bit = 1;
            if (current.children[1-bit] != null) {
                ans = ans | (1 << i);
                current = current.children[1-bit];
            }
            else if (current.children[bit] != null) {
                current = current.children[bit];
            }
            else {
                current.children[bit] = new TrieNodeMX();
                current = current.children[bit];
            }
        }
        return ans;
    }
}