package Crio.DSA_3.BT_and_BST;

import java.util.*;
public class BinaryTreeBoundaryTraversal {

    public ArrayList<Long> res = new ArrayList<>();
    public ArrayList<Long> binaryTreeBoundaryTraversal(TreeNode root) {
        res.add(root.val);
        leftBoundary(root.left);
        getLeaf(root.left);
        getLeaf(root.right);
        rightBoundary(root.right);
        return res;
    }

    private void rightBoundary(TreeNode root) {
        if (root == null) return;

        if(root.right != null){         // if - else if blocks eliminate chance of adding leaf node as both right and left are null for them
            rightBoundary(root.right);
            res.add(root.val);
        }else if(root.left != null){
            rightBoundary(root.left);
            res.add(root.val);
        }
    }

    private void leftBoundary(TreeNode root) {
        if (root == null) return;

        if(root.left != null){
            res.add(root.val);
            leftBoundary(root.left);
        }else if(root.right != null){
            res.add(root.val);
            leftBoundary(root.right);
        }
    }

    private void getLeaf(TreeNode root) {
        if (root == null) return;

        getLeaf(root.left);
        if(root.left == null && root.right == null) res.add(root.val);
        getLeaf(root.right);
    }
}
