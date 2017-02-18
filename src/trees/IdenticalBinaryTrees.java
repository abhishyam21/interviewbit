package trees;

/**
 * Created by abhishyam.c on 12/19/2016.
 */
public class IdenticalBinaryTrees {
    public static void main(String[] args) {
        int[] temp1 ={15,10,20,8,12,6,11,17,25,16,27};
        TreeNode a = TreeNode.getTreeNode(temp1);

        int[] temp2 ={15,10,20,8,12,6,11,17,25,16,34};
        TreeNode b = TreeNode.getTreeNode(temp2);
        IdenticalBinaryTrees identicalBinaryTrees = new IdenticalBinaryTrees();
        int identical = identicalBinaryTrees.isIdentical(a, b);
        System.out.println(identical);
    }

    private int isIdentical(TreeNode a, TreeNode b) {
        return isIdenticalTrees(a,b) ? 1:0;
    }

    private boolean isIdenticalTrees(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        return a != null && b != null && (a.val == b.val) && isIdenticalTrees(a.left, b.left) && isIdenticalTrees(a.right, b.right);
    }
}
