package trees;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * Created by Rachana Rao on 3/29/2017.
 */
public class DeleteTree {

    public static void main(String[] args) {
        int[] a = {15, 10, 20, 8, 12, 6, 11, 17, 25, 16, 27};
        TreeNode root = TreeNode.getTreeNode(a);
        TreeNode.printLevelOrderTraversalOfTree(root);
        System.out.println("-------------------------------");
        for (LinkedList<TreeNode> treeNodes : getDepthToList(root)) {
            for (TreeNode treeNode : treeNodes) {
                System.out.print(treeNode.val + "\t");
            }
            System.out.println("\n");
        }
    }

    private static ArrayList<LinkedList<TreeNode>> getDepthToList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        util(root, result, 0);
        return result;
    }

    private static void util(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int level) {
        if (root == null) return;
        LinkedList<TreeNode> treeNodes = null;
        if(result.size() >level){
            treeNodes = result.get(level);
            treeNodes.add(root);
            result.set(level,treeNodes);
        }else{
            treeNodes = new LinkedList<>();
            treeNodes.add(root);
            result.add(level,treeNodes);
        }
        util(root.left, result, 1 + level);
        util(root.right, result, 1 + level);
    }
}
