package Crio.DSA_3;
import java.util.*;
public class LowestCommonAncestorInBST {
    public TreeNode lowestCommonAncestorInBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        // As it is BST we can say that if p & q are greater than root then its on right and vice versa.
        if(root.val < p.val && root.val < q.val )  return lowestCommonAncestorInBST(root.right,p,q);
        else if(root.val > p.val && root.val > q.val ) return lowestCommonAncestorInBST(root.left,p,q);
        else return root;
    }
}
