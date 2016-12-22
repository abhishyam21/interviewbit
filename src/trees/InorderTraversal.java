package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by abhishyam.c on 12/17/2016.
 */
public class InorderTraversal {
    public static void main(String[] args) {
        int[] a ={15,10,20,8,12,6,11,17,25,16,27};
        TreeNode treeNode = TreeNode.getTreeNode(a);
        InorderTraversal inorderTraversal = new InorderTraversal();
        ArrayList<Integer> arrayList = inorderTraversal.inorderTraversal(treeNode);
        System.out.println(arrayList.toString());
    }

    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        addElementsToStack(stack,a);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
                result.add(node.val);
                if(node.right != null)
                    addElementsToStack(stack,node.right);
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
