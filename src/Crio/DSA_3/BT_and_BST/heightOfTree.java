package Crio.DSA_3.BT_and_BST;


public class heightOfTree {
    public int maxDepth(TreeNode root) {
        if( root == null ) return 0;
        return Math.max( maxDepth(root.left) , maxDepth(root.right) ) + 1;
    }
}
