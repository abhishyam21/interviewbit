package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Rachana Rao on 12/27/2016.
 */
public class PopulateNextRightPointersTree {
    public static void main(String[] args) {
        //int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
        int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 16, 24, 26, 34, 36};
        TreeLinkNode a = TreeLinkNode.getTreeNode(temp);
        PopulateNextRightPointersTree populateNextRightPointersTree = new PopulateNextRightPointersTree();
        populateNextRightPointersTree.poplulateNext(a);
        TreeLinkNode.printLevelOrderForNextTraversalOfTree(a);
    }

    private void poplulateNext(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() > 1) {
            TreeLinkNode node = queue.poll();
            if (node == null) queue.add(node);
            else if (node != null) {
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                node.next = queue.peek();
            }
        }
    }
}