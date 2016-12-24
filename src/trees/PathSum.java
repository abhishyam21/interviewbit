package trees;

/**
 * Created by Rachana Rao on 12/24/2016.
 */
public class PathSum {
    public static void main(String[] args) {
        int[] temp ={20,10,30,5,15,25,35,4,6,14,16,24,26,34,36};
        TreeNode a = TreeNode.getTreeNode(temp);
        PathSum pathSum = new PathSum();
        int b = 101;
        pathSum.pathSum(a,b);
    }

    private int pathSum(TreeNode a, int b) {
        return 0;
    }
}
