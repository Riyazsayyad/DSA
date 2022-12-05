package LeetCode;
import java.util.*;

public class CountNodes {
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<Integer> level = new ArrayList<Integer>();
        if(root ==null) return 0;
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode curr = q.remove();
                level.add((int)curr.val);
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
        }
        return level.size();
    }
}
//       public int countNodes(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        return 1+countNodes(root.left)+countNodes(root.right);
//    }
