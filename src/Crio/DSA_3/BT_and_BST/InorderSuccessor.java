package Crio.DSA_3.BT_and_BST;

import java.util.ArrayDeque;
import java.util.Deque;

public class InorderSuccessor {
    public int inorderSuccessor(TreeNode root, TreeNode givenNode)
    {
        // Iterative inOrder traversal, O(1) space solution failing
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if(root.val > givenNode.val)    return (int)root.val;
            root = root.right;
        }
        return -1;
    }

//    private void inOrder(TreeNode root, TreeNode givenNode) {
//        if(root == null) return;
//
//        inOrder(root.left,givenNode);
//        if(root.val > givenNode.val && ans.left == null){
//            ans.left = new TreeNode(0);
//            ans = root;
//            return;
//        }
//        inOrder(root.right,givenNode);
//    }
}
