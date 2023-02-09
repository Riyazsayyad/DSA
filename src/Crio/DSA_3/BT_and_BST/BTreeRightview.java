package Crio.DSA_3.BT_and_BST;


import java.util.*;
public class BTreeRightview {

    public ArrayList<Long> rightViewBinaryTree(TreeNode root) {
        Map<Long , Long> map = new HashMap<>();
        rightTraversal(root,0L,map);
        int level = map.size();
        ArrayList<Long> ans = new ArrayList<>();
        for (long i = 0; i < level; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    private void rightTraversal(TreeNode root, long level, Map<Long, Long> map) {
        if(root != null){
            map.putIfAbsent(level,(long)root.val);
            rightTraversal(root.right,level+1,map);
            rightTraversal(root.left,level+1,map);
        }
    }
}
