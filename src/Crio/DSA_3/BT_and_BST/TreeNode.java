package Crio.DSA_3.BT_and_BST;

  public class TreeNode {
      long val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(long val) { this.val = val; }
      TreeNode(long val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }
