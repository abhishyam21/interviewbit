package codeninja;

import trees.TreeNode;

/**
 * Created by Rachana Rao on 5/16/2017.
 */
public class BuildIdenticalTrees {
    private int result = 0;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.right = new TreeNode(25);
        node1.right.right.right = new TreeNode(30);

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);
        node2.left.left = new TreeNode(4);
        node2.left.left.right = new TreeNode(5);

        node2.right.left = new TreeNode(6);
        node2.right.right = new TreeNode(7);
        node2.right.right.left = new TreeNode(8);

        BuildIdenticalTrees buildIdenticalTrees = new BuildIdenticalTrees();
        System.out.println(buildIdenticalTrees.cntMatrix(node1, node2));
    }

    private int cntMatrix(TreeNode node1, TreeNode node2) {
        util(node1, node2);
        return result;
    }

    private void util(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return;
        if (node1 != null && node2 == null) result = -1;
        if (node2 != null && node1 == null) {
            result++;
            util(null, node2.left);
            util(null, node2.right);
        } else if (node1 != null && node2 != null) {
            util(node1.left, node2.left);
            util(node1.right, node2.right);
        }
    }
}
