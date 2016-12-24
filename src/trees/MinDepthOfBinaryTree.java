package trees;

/**
 * Created by Rachana Rao on 12/24/2016.
 */
public class MinDepthOfBinaryTree {
    public static void main(String[] args) {
        MinDepthOfBinaryTree maxDepthOfBinaryTree = new MinDepthOfBinaryTree();
        int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
        TreeNode a = TreeNode.getTreeNode(temp);
        int height = maxDepthOfBinaryTree.maxDepth(a);
        System.out.println(height);
    }

    private int maxDepth(TreeNode a) {
        return depth(a,0);
    }

    private int depth(TreeNode a, int depth) {
        if(a==null)
            return Integer.MAX_VALUE;
        if(a.left == null  && a.right == null)
            return ++depth;
        int left = depth(a.left, (depth+1));
        int right = depth(a.right, (depth+1));
        return Math.min(left, right);
    }
}
