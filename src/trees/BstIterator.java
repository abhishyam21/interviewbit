package trees;

import java.util.Stack;

/**
 * Created by abhishyam.c on 12/26/2016.
 */
public class BstIterator {
    static class Solution {
        private Stack<TreeNode> stack = new Stack<>();
        public Solution(TreeNode root) {
            addRightTreeValues(root);
        }
        public static void main(String[] args) {
        int[] temp1 = {15, 10, 20, 8, 12, 6, 11, 17, 25, 16, 27};
        TreeNode a = TreeNode.getTreeNode(temp1);
         Solution solution = new Solution(a);
            while (solution.hasNext()){
                System.out.println(solution.next());
            }
    }

        private int next() {
            TreeNode node = stack.pop();
            addRightTreeValues(node.right);
            return node.val;
        }

        private void addRightTreeValues(TreeNode node) {
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }

        private boolean hasNext() {
            return !stack.isEmpty();
        }

    }
}
