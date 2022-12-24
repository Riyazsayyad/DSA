package Crio.DSA_3;
import java.util.*;
public class ConstructBT_PostorderAndInorder {
    public TreeNode root;
    static int preIndex = 0;
    public HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode constructBinaryTreeFromPostorderAndInorderTraversal(int[] postorder, int[] inorder) {
        var n = postorder.length;
        preIndex = n - 1;
        for (int i = 0; i < n; i++) map.put(inorder[i],i);
        return buildTree(inorder,0, n-1,postorder,0,n-1);
    }

    private TreeNode buildTree(int[] inorder,int iS, int iE,int[] postorder, int pS, int pE) {
        // Base condition and root initialization
        if( iS > iE || pS > pE)    return null;
        TreeNode tNode = new TreeNode(postorder[pE]);

        //Searching root in inOrder (left of inOrder seq is left subtree and same with right)
        int midR = map.get((int)tNode.val);

        tNode.left = buildTree(inorder,iS,midR-1,postorder,pS,pS+midR-(iS+1));
        tNode.right = buildTree(inorder,midR+1,iE,postorder,pS+midR-iS,pE-1);

        return tNode;
    }
}

