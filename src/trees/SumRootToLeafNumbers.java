package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Rachana Rao on 12/24/2016.
 */
public class SumRootToLeafNumbers {
    private static int MOD = 1003;
    public static void main(String[] args) {
       int[] temp = {2,1,3};
     //   int[] temp = {1000,200};
        TreeNode a = TreeNode.getTreeNode(temp);
        SumRootToLeafNumbers pathSum = new SumRootToLeafNumbers();
        int b = 101;
        int i = pathSum.pathSum(a);
        System.out.println(i);
    }

    private int pathSum(TreeNode a) {
        int result =0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = null;
        TreeNode prev;
        TreeNode node = a;
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
                    result+=checkSum(stack);
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
        return result%MOD;
    }

    private int checkSum(Stack<TreeNode> stack) {
        Object[] temp = stack.toArray();
        int sum = 0;
        for (Object o : temp) {
            TreeNode treeNode = (TreeNode) o;
            sum=sum*10+treeNode.val;
            sum%=MOD;
        }
        sum = sum%MOD;
        return  sum;
    }
}
