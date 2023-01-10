package LeetCode;
import java.util.*;
public class IterativePreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            if(root != null){
                ans.add(root.val);
                stack.add(root.right);
                root = root.left;
            }
            else {
                root = stack.pop();
            }
        }
        return ans;
    }
}
