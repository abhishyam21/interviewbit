package trees;

/**
 * Created by Rachana Rao on 12/24/2016.
 */
public class KthSmallestElementInTree {
    private int count = 0;
    private int result = 0;
    public static void main(String[] args) {
       // int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
        int[] temp = {2,1,3};
        TreeNode a = TreeNode.getTreeNode(temp);
        KthSmallestElementInTree kthSmallestElementInTree = new KthSmallestElementInTree();
        int b = 1;
        int i = kthSmallestElementInTree.kthsmallest(a, b);
        System.out.println(i);
    }

    private int kthsmallest(TreeNode root, int k) {

        if(root == null)
            return 0;
        kthsmallest(root.left,k);
        count++;
        if(count == k)
            result = root.val;
        kthsmallest(root.right,k);
        return result;

    }
}
