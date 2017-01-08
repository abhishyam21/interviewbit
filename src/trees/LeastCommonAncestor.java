package trees;

/**
 * Created by Rachana Rao on 12/29/2016.
 */
public class LeastCommonAncestor {
    public static void main(String[] args) {
        LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor();
        int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
        TreeNode a = TreeNode.getTreeNode(temp);
        int b = 35, c=36;
        int i = leastCommonAncestor.lca(a, b, c);
        System.out.println(i);
    }

    private int lca(TreeNode a, int val1, int val2) {
        if(a == null) return -1;
        if(a.val == val1 || a.val == val2) return a.val;
        int left = lca(a.left,val1,val2);
        int right = lca(a.right,val1,val2);

        if(left != -1 && right != -1) return a.val;
        if(left ==-1 && right == -1) return -1;
        return left!=-1? left:right;
    }
}
