package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by abhishyam.c on 12/17/2016.
 */
public class PostOrderTraversal {
    public static void main(String[] args) {
       // int[] a ={15,10,20,8,12,6,11,17,25,16,27};
        int[] a ={20,10,30,5,15,25,35,4,6,14,16,24,26,34,36};
        TreeNode treeNode = TreeNode.getTreeNode(a);
        PostOrderTraversal inorderTraversal = new PostOrderTraversal();
        ArrayList<Integer> arrayList = inorderTraversal.postorderTraversal(treeNode);
        System.out.println(arrayList.toString());
    }

    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> isVisitedStack = new Stack<>();
        addElementsToStack(stack,a);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(!isVisitedStack.isEmpty() && node==isVisitedStack.peek()){
                result.add(isVisitedStack.pop().val);
            }else {
                if (node.right == null)
                    result.add(node.val);
                else {
                    isVisitedStack.push(node);
                    stack.add(node);
                    addElementsToStack(stack, node.right);
                }
            }
        }
        return result;
    }

    private void addElementsToStack(Stack<TreeNode> stack, TreeNode temp) {
        while (temp != null){
            stack.push(temp);
            temp = temp.left;
        }
    }
}
