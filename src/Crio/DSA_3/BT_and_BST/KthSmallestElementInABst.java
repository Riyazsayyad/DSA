package Crio.DSA_3.BT_and_BST;

public class KthSmallestElementInABst {
    private int ans;
    public int kthSmallestElementInABst(TreeNode root, int k) {
        kRecurse(root,k,0);
        return ans;
    }

    private int kRecurse(TreeNode node, int k, int num) {
        if(node == null) return num;
        // simple in order traversal && and keeping count of visited nodes so that kth smallest can be found
        // NOTE : In order traversal in BST gives out the sorted ascending sequence.
        int count = kRecurse(node.left,k,num);
        count++;
        if(count == k) ans = (int)node.val;
        return kRecurse(node.right,k,count);
    }
}
