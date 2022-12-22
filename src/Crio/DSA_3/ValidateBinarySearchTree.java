package Crio.DSA_3;

import java.util.Stack;

public class ValidateBinarySearchTree {
    boolean validateBinarySearchTree(TreeNode root) {
        return validate(root,0,100000);
    }

    private boolean validate(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val < min || root.val > max)    return false;
        return validate(root.left,min,root.val-1) && validate(root.right,root.val+1,max);
        //Session - 9 58:37
    }
}

/*
    public Stack<Long> stack  = new Stack<>();
    public boolean flag = true;

    boolean validateBinarySearchTree(TreeNode root) {
        inOrder(root);
        return flag;
    }

    private void inOrder(TreeNode root) {
        if(root == null) return;

        inOrder(root.left);
        if(stack.isEmpty() || stack.peek() < root.val) stack.add(root.val);
        else flag &= false;
        inOrder(root.right);
    }
    */