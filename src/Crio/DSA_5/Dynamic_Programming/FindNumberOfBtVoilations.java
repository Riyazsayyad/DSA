package Crio.DSA_5.Dynamic_Programming;

public class FindNumberOfBtVoilations {
    static int result;
    public int findNumberOfBtVoilations(TreeNode root) {
        result = 0;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root) {
        if(root == null) return;

        if(root.left != null && root.val > root.left.val) result++;
        if(root.right != null && root.val < root.right.val) result++;
        inOrder(root.left);
        inOrder(root.right);
    }
}
