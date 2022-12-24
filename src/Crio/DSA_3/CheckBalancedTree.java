package Crio.DSA_3;

public class CheckBalancedTree {
    private boolean flag = true;
    boolean checkBalanced(TreeNode root) {
        getHeight(root);
        return flag;
    }

    private int getHeight(TreeNode node) {
        if(node == null) return 0;
        int left = getHeight(node.left) + 1;
        int right = getHeight(node.right) + 1;
        if(Math.abs(left - right) > 1) flag = false;
        return Math.max(left,right);
    }
}
