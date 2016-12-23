package trees;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhishyam.c on 12/20/2016.
 */
public class SortedArrayToBalancedBst {
    public static void main(String[] args) {
        Integer[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        SortedArrayToBalancedBst sortedArrayToBalancedBst = new SortedArrayToBalancedBst();
        TreeNode bst = sortedArrayToBalancedBst.createBST(a);
        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();
        System.out.println(validBinarySearchTree.isValidBST(bst));
        TreeNode.printLevelOrderTraversalOfTree(bst);
    }

    private TreeNode createBST(ArrayList<Integer> a) {
        return createTree(a, 0, a.size() - 1);
    }

    private TreeNode createTree(ArrayList<Integer> a, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(a.get(mid));
        root.left = createTree(a, start, (mid - 1));
        root.right = createTree(a, (mid + 1), end);
        return root;
    }
}
