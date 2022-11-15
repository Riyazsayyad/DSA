package Crio.DSA_1;
import java.util.*;
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> lst = new ArrayList();
        Queue<TreeNode> q = new LinkedList();

        if(root ==null)
            return lst;
        q.offer(root);
        while(!q.isEmpty()){

            int n=q.size();
            List<Integer> level = new ArrayList<Integer>();

            for(int i=0;i<n;i++){
                TreeNode curr = q.remove();
                level.add((int)curr.val);
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
            lst.add(level);
        }
        return lst;
    }
}
