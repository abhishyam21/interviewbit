package trees;

/**
 * Created by Rachana Rao on 12/29/2016.
 */
public class LeastCommonAncestor {
    private int lca;
    public static void main(String[] args) {
        LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor();
        int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
        TreeNode a = TreeNode.getTreeNode(temp);
        int b = 35, c=36;
        int i = leastCommonAncestor.lca(a, b, c);
        System.out.println(i);
    }

    private int lca(TreeNode a, int val1, int val2) {
        if (isNodeExists(a, val1) && isNodeExists(a, val2)) {
            lcaUtil(a, val1, val2);
            return lca;
        } else return -1;
    }

    private boolean lcaUtil(TreeNode a, int val1, int val2) {
        if (a == null) return false;
        //if one of the node is find, then assign that to
        //lca
        if (a.val == val1 || a.val == val2) {
            lca = a.val;
            return true;
        }
        boolean left = lcaUtil(a.left, val1, val2);
        boolean right = lcaUtil(a.right, val1, val2);

        if (left && right) lca = a.val;
        return left || right;
    }

    /**
     * Check if node exists in the given tree
     */
    private boolean isNodeExists(TreeNode a, int val) {
        if (a == null) return false;
        if (a.val == val) return true;
        return isNodeExists(a.left, val) || isNodeExists(a.right, val);
    }
}
