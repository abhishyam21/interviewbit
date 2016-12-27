package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rachana Rao on 12/25/2016.
 */
public class TwoSumBinaryTree {
    int result = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
        TreeNode a = TreeNode.getTreeNode(temp);
        int b = 28;
        TwoSumBinaryTree twoSumBinaryTree = new TwoSumBinaryTree();
        int i = twoSumBinaryTree.t2Sum(a, b);
        System.out.println(i);
    }

    private int t2Sum(TreeNode A, int B) {
        if (A == null)
            return result;
        t2Sum(A.left, B);
        int val = A.val;
        int diff = (B - val);
        if (map.containsKey(diff)) {
            result = 1;
            return result;
        }
        if (val < diff)
            map.put(val, val);
        return t2Sum(A.right, B);
    }
}
