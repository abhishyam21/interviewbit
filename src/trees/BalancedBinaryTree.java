package trees;

/**
 * Created by abhishyam.c on 12/19/2016.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        int[] a ={15,10,20,8,12,6,11,17,25,16,27};
        //int[] a ={1,2,3,4,5};
        TreeNode treeNode = TreeNode.getTreeNode(a);
        TreeNode.printLevelOrderTraversalOfTree(treeNode);
        BalancedBinaryTree balancedBinaryTree =new BalancedBinaryTree();
        int i = balancedBinaryTree.balancedBinaryTree(treeNode);
        System.out.println(i);
    }

    private int balancedBinaryTree(TreeNode a) {
        return isBalancedTree(a) ? 1:0;
    }

    private boolean isBalancedTree(TreeNode a) {
        if(a == null)
            return true;
        int leftHeight = heightOfTree(a.left);
        int rightHeight = heightOfTree(a.right);
        return !(Math.abs(leftHeight - rightHeight) > 1) && isBalancedTree(a.left) && isBalancedTree(a.right);
    }

    private int heightOfTree(TreeNode a) {
        if(a == null)
            return 1;
        int l= heightOfTree(a.left);
        int r =heightOfTree(a.right);
        return Math.max(l,r)+1;
    }
}
