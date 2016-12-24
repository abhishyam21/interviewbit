package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Rachana Rao on 12/24/2016.
 */
public class RootToLeafPathsWithSum {
    public static void main(String[] args) {
       int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
     //   int[] temp = {1000,200};
        TreeNode a = TreeNode.getTreeNode(temp);
        RootToLeafPathsWithSum pathSum = new RootToLeafPathsWithSum();
        int b = 101;
        ArrayList<ArrayList<Integer>> i = pathSum.pathSum(a, b);
        for (ArrayList<Integer> integers : i) {
            System.out.println(integers.toString());
        }
    }

    private ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = null;
        TreeNode prev;
        TreeNode node = root;
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.isEmpty())
                break;
            else {
                prev = current;
                current = stack.peek();
                if (current.left == null && current.right == null) {
                    checkSum(stack,result,sum);
                    stack.pop();
                } else {
                    if (prev == current.right) {
                        stack.pop();
                    }else if (current.right != null) {
                        node = current.right;
                    }
                    if(current.right == null)
                        stack.pop();
                }
            }
        }
        return result;
    }

    private void checkSum(Stack<TreeNode> stack, ArrayList<ArrayList<Integer>> result, int b) {
        Object[] temp = stack.toArray();
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (Object o : temp) {
            TreeNode treeNode = (TreeNode) o;
            sum+=treeNode.val;
            list.add(treeNode.val);
        }
        if(b ==sum)
            result.add(list);
    }
}
