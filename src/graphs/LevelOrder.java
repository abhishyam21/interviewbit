package graphs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Rachana Rao on 3/25/2017.
 */
public class LevelOrder {
    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        int[] numbers ={20,10,30,5,15,25,35,4,6,14,16,24,26,34,36};
        TreeNode a = TreeNode.getTreeNode(numbers);
        TreeNode.printLevelOrderTraversalOfTree(a);
        System.out.println("--------------------------------------------");
        ArrayList<ArrayList<Integer>> arrayLists = levelOrder.levelOrder(a);
        arrayLists.forEach(list -> System.out.println(list.toString()));
    }

    private ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(a);
        queue.add(null);
        ArrayList<Integer> temp = new ArrayList<>();
        while (queue.size()>1){
            TreeNode peek = queue.poll();
            if(peek == null){
                    result.add(temp);
                    temp = new ArrayList<>();
                    queue.add(null);
            }else {
                temp.add(peek.val);
                if(peek.left != null)
                queue.add(peek.left);
                if(peek.right != null)
                queue.add(peek.right);
            }
        }
        result.add(temp);
        return result;
    }
}
