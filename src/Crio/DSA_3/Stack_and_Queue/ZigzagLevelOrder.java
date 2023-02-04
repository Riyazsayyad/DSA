package Crio.DSA_3.Stack_and_Queue;

import java.util.*;
public class ZigzagLevelOrder {
    public List<List<Long>>  zigzagLevelOrder(TreeNode root) {

        List<List<Long>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level =0;
        while(!queue.isEmpty()){
            List<Long> subLst = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                subLst.add((long) curr.val);
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null)    queue.add(curr.right);
            }

            if(level%2==1) Collections.reverse(subLst);
            level++;
            ans.add(subLst);
        }
        return ans;
    }

}
