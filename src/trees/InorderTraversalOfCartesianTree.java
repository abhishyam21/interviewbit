package trees;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 12/24/2016.
 */
public class InorderTraversalOfCartesianTree {
    public static void main(String[] args) {
        Integer[] temp ={15,10,20,8,12,6,11,17,25,16,27};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        InorderTraversalOfCartesianTree inorderTraversalOfCartesianTree = new InorderTraversalOfCartesianTree();
        inorderTraversalOfCartesianTree.buildTree(a);
    }

    private TreeNode buildTree(ArrayList<Integer> a) {
        TreeNode root;

        if (a == null)
            return null;

        root = rec(a, 0, a.size() - 1);

        return root;
    }

    public TreeNode rec(ArrayList<Integer> A, int start, int end) {

        int maxIndex = start;

        if (start > end)
            return null;

        for (int i = start + 1; i <= end; i++) {
            if (A.get(maxIndex) < A.get(i)) {
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(A.get(maxIndex));

        node.left = rec(A, start, maxIndex - 1);
        node.right = rec(A, maxIndex + 1, end);

        return node;
    }
}
