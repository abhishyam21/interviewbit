package trees;

/**
 * Created by Rachana Rao on 12/27/2016.
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
        TreeNode a = TreeNode.getTreeNode(temp);

        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        TreeNode treeNode = flattenBinaryTreeToLinkedList.flatten(a);
        TreeNode.printLevelOrderTraversalOfTree(treeNode);

    }

    private TreeNode flatten(TreeNode a) {
        if (a == null) return null;
        //flatten(a.left);
        if(a.left != null) {
            TreeNode left = a.left;
            TreeNode right = a.right;
            a.left = null;
            append(left, right);
            a.right = left;
        }
        flatten(a.right);
        return a;
    }

    private void append(TreeNode left, TreeNode right) {
        TreeNode temp = left;
        while (temp.right != null) temp = temp.right;
        temp.right = right;
    }
}