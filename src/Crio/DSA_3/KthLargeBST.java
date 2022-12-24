package Crio.DSA_3;

public class KthLargeBST {
    private long ans;
    public long kthLargestElementInABst(TreeNode root, int k) {
        kRecurse(root,k,0);
        return ans;
    }
    private int kRecurse(TreeNode node, int k,int num) {
        if(node == null) return num;
        // simple in order traversal and keeping count of visited nodes so that kth largest can be found
        // NOTE : In order traversal in BST gives out the sorted ascending sequence.
        int count = kRecurse(node.right,k,num);
        count++;
        if(count == k) ans = node.val;
        return kRecurse(node.left,k,count);
    }
}
