package LeetCode;

public class MaxProductSplittedTree {
    static long sum;
    static long maxProd;

    public  int maxProduct(TreeNode root) {
        sum = (long) totalSum(root);
        maxProd =0;
        getMaxProd(root);
        return (int)(maxProd % ((int)Math.pow(10, 9) + 7));
    }

    public static long getMaxProd(TreeNode root) {
        if(root == null) return 0;
        long l = (getMaxProd(root.left));
        long r = (getMaxProd(root.right));
        maxProd = Math.max(maxProd, (l + r + root.val) * (sum - l - r - root.val));
        return l + r + root.val;
    }

    private int totalSum(TreeNode root) {
        if(root == null) return 0;
        return (root.val + totalSum(root.left) + totalSum(root.right));
    }
}
