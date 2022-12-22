package Crio.DSA_3;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode root;
    static int preIndex = 0 ;
    public HashMap<Integer,Integer> map = new HashMap<>();

    private TreeNode buildTree(int[] inorder,int[] preorder,int inStart, int inEnd ) {
        // Base condition and root initialization
        if( inStart > inEnd)    return null;
        TreeNode tNode = new TreeNode(preorder[preIndex++]);
        if(inEnd == inStart) return tNode;

        //Searching root in inOrder (left of inOrder seq is left subtree and same with right)
        int midR = map.get((int)tNode.val);

        tNode.left = buildTree(inorder,preorder,inStart,midR-1);
        tNode.right = buildTree(inorder,preorder,midR+1,inEnd);

        return tNode;
    }

    public TreeNode constructBinaryTreeFromPreorderAndInorderTraversal(int[] preorder, int[] inorder) {
        var n = preorder.length;
        for (int i = 0; i < n; i++) map.put(inorder[i],i);
        return buildTree(inorder,preorder,0, n-1);
    }
}
