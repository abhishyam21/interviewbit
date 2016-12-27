package trees;

import java.util.ArrayList;

/**
 * Created by Rachana Rao on 12/27/2016.
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
        TreeNode a = TreeNode.getTreeNode(temp);

        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        TreeNode treeNode = flattenBinaryTreeToLinkedList.flattenBinaryTreeToLinkedList(a);
        ZigZagLevelOrderTraversalBt zigZagLevelOrderTraversalBt = new ZigZagLevelOrderTraversalBt();
        ArrayList<ArrayList<Integer>> arrayLists = zigZagLevelOrderTraversalBt.zigZagLevelOrderTraversalBt(treeNode);
        arrayLists.forEach(list -> System.out.println(list.toString()));
    }

    private TreeNode flattenBinaryTreeToLinkedList(TreeNode a) {
        if (a == null) return null;
        flattenBinaryTreeToLinkedList(a.left);
        TreeNode left = a.left;
        TreeNode right = a.right;
        a.left = null;
        append(left, right);
        a.right = left;
        flattenBinaryTreeToLinkedList(a.right);
        return a;
    }

    private void append(TreeNode left, TreeNode right) {
        TreeNode temp = left;
        while (temp.right != null) temp = temp.right;
        temp.right = right;
    }
}
