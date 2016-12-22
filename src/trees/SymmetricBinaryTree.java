package trees;

/**
 * Created by abhishyam.c on 12/19/2016.
 */
public class SymmetricBinaryTree {
    public static void main(String[] args) {
        int[] a ={15,10,20,8,12,6,11,17,25,16,27};
        TreeNode treeNode = TreeNode.getTreeNode(a);
        SymmetricBinaryTree symmetricBinaryTree = new SymmetricBinaryTree();
        int i = symmetricBinaryTree.symmetricBinaryTree(treeNode);
        System.out.println(i);
    }

    private int symmetricBinaryTree(TreeNode a) {
        return isIdenticalTrees(a.left,a.right) ? 1:0;
    }

    private boolean isIdenticalTrees(TreeNode a, TreeNode b) {
        if(a == null && b==null)
            return true;
        if(a!=null && b!= null)
            return (a.val==b.val) && isIdenticalTrees(a.left,b.right) && isIdenticalTrees(a.right,b.left);
        else return false;
    }
}
