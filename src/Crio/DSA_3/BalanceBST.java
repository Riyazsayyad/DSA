package Crio.DSA_3;

import java.util.*;
public class BalanceBST {
    public ArrayList<Long> inOrderseq = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        int n = inOrderseq.size();
        return buildBalTree(inOrderseq,0,n-1);
    }

    private TreeNode buildBalTree(ArrayList<Long> inOrderseq, int start, int end) {
        if(start > end) return null;

        int mid = (start + end)/2;
        TreeNode root = new TreeNode(inOrderseq.get(mid));
        root.left = buildBalTree(inOrderseq,start,mid-1);
        root.right = buildBalTree(inOrderseq,mid+1,end);
        return root;
    }


    private void inOrder(TreeNode node){
        if(node == null) return;

        inOrder(node.left);
        inOrderseq.add(node.val);
        inOrder(node.right);
    }
}
