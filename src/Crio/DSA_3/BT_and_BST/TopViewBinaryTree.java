package Crio.DSA_3.BT_and_BST;

import java.util.*;
public class TopViewBinaryTree {
    public class NodeX {
        public TreeNode node;
        public int level;

        NodeX(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }

    public ArrayList<Long> topViewBinaryTree(TreeNode root) {
        ArrayList<Long> res = new ArrayList<>();

        Map<Integer, Long> map = new HashMap<>();
        Queue<NodeX> queue = new LinkedList<>();

        queue.offer(new NodeX(root,0));
        int start = 0, end = 0;

        while (!queue.isEmpty()){
            NodeX nodeX = queue.poll();
            map.putIfAbsent(nodeX.level, nodeX.node.val);
            start = Math.min(start,nodeX.level);
            end = Math.max(end,nodeX.level);
            if(nodeX.node.left != null) queue.offer(new NodeX(nodeX.node.left,nodeX.level-1));
            if(nodeX.node.right != null) queue.offer(new NodeX(nodeX.node.right,nodeX.level+1));
        }
        for (int i = start; i <= end; i++) res.add(map.get(i));
        return res;
    }
}
