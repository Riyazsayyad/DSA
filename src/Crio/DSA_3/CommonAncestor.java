package Crio.DSA_3;

public class CommonAncestor {
    TreeNode commonAncestor(TreeNode root, TreeNode p , TreeNode q) {
        if(root == null || p == root || q == root) return root;
        else {

            TreeNode left = commonAncestor(root.left,p,q);
            TreeNode right = commonAncestor(root.right,p,q);

            if(left != null && right != null)   return root;
            else if(left != null) return left;
            else return right;
        }
    }
}
