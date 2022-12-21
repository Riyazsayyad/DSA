package Crio.DSA_3;

public class MirrorBinaryTree {
    public TreeNode mirrorBinaryTree(TreeNode root) {
        Mirror(root);
        return root;
    }

    private void swapNodes(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    private void Mirror(TreeNode root) {
        if(root == null) return;

        swapNodes(root);
        Mirror(root.left);
        Mirror(root.right);
    }
}
