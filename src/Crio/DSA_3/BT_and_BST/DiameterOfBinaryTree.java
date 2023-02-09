package Crio.DSA_3.BT_and_BST;


public class DiameterOfBinaryTree {
    public int maxDiameter = 0;
    public int getDiameter(TreeNode root){
        if(root == null) return 0;

        int left = getDiameter(root.left);
        int right = getDiameter(root.right);

        maxDiameter = Math.max(maxDiameter,left + right);

        return Math.max(left,right)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return maxDiameter;
    }
}
