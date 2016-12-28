package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Rachana Rao on 12/27/2016.
 */
public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
    private static TreeLinkNode root;
    static TreeLinkNode getTreeNode(int[] numbers){
        root = new TreeLinkNode(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            int num = numbers[i];
            TreeLinkNode temp = root;
            TreeLinkNode prev = temp;
            while (temp != null){
                prev = temp;
                if(temp.val > num)//left Side
                    temp = temp.left;
                else//right side
                    temp = temp.right;
            }
            if(prev.val > num){
                prev.left = new TreeLinkNode(num);
            }else {
                prev.right = new TreeLinkNode(num);
            }
        }
        return root;
    }

    public static void printLevelOrderForNextTraversalOfTree(TreeLinkNode tree){
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(tree);
        queue.add(null);
        while (queue.size()>1){
            TreeLinkNode node = queue.poll();
            if(node == null) {
                System.out.print("\n");
                queue.add(null);
            }
            else {
                System.out.print(node.val);
                if(node.next == null){
                    System.out.print("-->null");
                }else System.out.print("-->"+node.next.val);
                System.out.print("\t");
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        System.out.println("");
    }
}
