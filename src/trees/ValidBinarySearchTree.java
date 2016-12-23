package trees;

/**
 * Created by abhishyam.c on 12/17/2016.
 */
public class ValidBinarySearchTree {
    public static void main(String[] args) {
        int[] a ={15,10,20,8,12,6,11,17,25,16,27};
        TreeNode treeNode = TreeNode.getTreeNode(a);
        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();
        int validBST = validBinarySearchTree.isValidBST(treeNode);
        System.out.println(validBST);
    }

    public int isValidBST(TreeNode a) {
        return     BTSUtil(a,Integer.MIN_VALUE,Integer.MAX_VALUE)? 1:0;
    }

    private boolean BTSUtil(TreeNode a, int minValue, int maxValue) {
        if(a ==null)
            return true;
        if(a.val > minValue && a.val < maxValue
                && BTSUtil(a.left,minValue,a.val) &&
                BTSUtil(a.right, a.val,maxValue))
            return true;
        else return false;
    }
}
