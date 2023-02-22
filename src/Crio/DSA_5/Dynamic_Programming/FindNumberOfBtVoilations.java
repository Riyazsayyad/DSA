package Crio.DSA_5.Dynamic_Programming;

public class FindNumberOfBtVoilations {

    public int findNumberOfBtVoilations(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = root.left != null ? getHeight(root.left) : 0;
        int rightHeight = root.right != null ? getHeight(root.right) : 0;

        if(Math.abs(leftHeight - rightHeight) > 1) return 1 + findNumberOfBtVoilations(root.left) + findNumberOfBtVoilations(root.right);
        else return findNumberOfBtVoilations(root.left) + findNumberOfBtVoilations(root.right);
    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }
}
