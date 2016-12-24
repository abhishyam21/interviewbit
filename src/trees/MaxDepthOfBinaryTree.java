package trees;

/**
 * Created by Rachana Rao on 12/24/2016.
 */
public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
        int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
        TreeNode a = TreeNode.getTreeNode(temp);
        int height = maxDepthOfBinaryTree.maxDepth(a);
        System.out.println(height);
    }

    private int maxDepth(TreeNode a) {
        return depth(a);
    }

    private int depth(TreeNode a) {
        if(a==null)
            return 0;
        int left = depth(a.left);
        int right = depth(a.right);
        int max = Math.max(left, right);
        return max+1;
    }
}
