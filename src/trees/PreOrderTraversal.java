package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by abhishyam.c on 12/17/2016.
 */
public class PreOrderTraversal {
    public static void main(String[] args) {
        //int[] a ={15,10,20,8,12,6,11,17,25,16,27};
        int[] a ={20,10,30,5,15,25,35,4,6,14,16,24,26,34,36};
        TreeNode treeNode = TreeNode.getTreeNode(a);
        PreOrderTraversal inorderTraversal = new PreOrderTraversal();
        ArrayList<Integer> arrayList = inorderTraversal.preorderTraversal(treeNode);
        System.out.println(arrayList.toString());
    }

    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        addElementsToStack(stack,a,result);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null)
                addElementsToStack(stack,node.right,result);
        }
        return result;
    }

    private void addElementsToStack(Stack<TreeNode> stack, TreeNode temp, ArrayList<Integer> result) {
        while (temp != null){
            result.add(temp.val);
            stack.push(temp);
            temp = temp.left;
        }
    }
}
