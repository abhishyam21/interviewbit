package trees;

/**
 * Created by abhishyam.c on 12/26/2016.
 */
public class InvertTheBinaryTree {

    public static void main(String[] args) {
        int[] temp1 ={15,10,20,8,12,6,11,17,25,16,27};
       // int[] temp1 ={7,2,1,4,3,5,6};
        TreeNode a = TreeNode.getTreeNode(temp1);
        InvertTheBinaryTree invertTheBinaryTree = new InvertTheBinaryTree();
        TreeNode invertedTree = invertTheBinaryTree.invertTree(a);
        System.out.println("\n");
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        return root;
    }
}
