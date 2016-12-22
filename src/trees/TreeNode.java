package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abhishyam.c on 12/17/2016.
 */
public class TreeNode {
    private static TreeNode root;
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }

    static TreeNode getTreeNode(int[] numbers){
        root = new TreeNode(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
                int num = numbers[i];
            TreeNode temp = root;
            TreeNode prev = temp;
            while (temp != null){
                prev = temp;
                if(temp.val > num)//left Side
                    temp = temp.left;
                else//right side
                    temp = temp.right;
            }
                if(prev.val > num){
                    prev.left = new TreeNode(num);
                }else {
                    prev.right = new TreeNode(num);
                }
        }
        return root;
    }

    public static void printLevelOrderTraversalOfTree(TreeNode tree){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        queue.add(null);
        while (queue.size()>1){
            TreeNode node = queue.poll();
            if(node == null) {
                System.out.print("\n");
                queue.add(null);
            }
            else {
                System.out.print(node.val + "\t");
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        System.out.println("");
    }
}
