package LeetCode;

import java.util.*;

public class HouseRobberIII {

    public int rob(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1,evenSum = 0,oddSum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(level % 2 == 0) evenSum += curr.val;
                else oddSum += curr.val;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            level++;
        }
        return Math.max(evenSum,oddSum);
    }
}