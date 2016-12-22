package trees;

/**
 * Created by abhishyam.c on 12/19/2016.
 */
public class HeightOfTree {
    public static void main(String[] args) {
        int[] a ={15,10,20,8,12,6,11,17,25,16,27};
        TreeNode treeNode = TreeNode.getTreeNode(a);
        HeightOfTree heightOfTree = new HeightOfTree();
        int height = heightOfTree.heightOfTree(treeNode);
        System.out.println(height);

        int leftHeight = heightOfTree.heightOfTree(treeNode.left);
        int rightHeight = heightOfTree.heightOfTree(treeNode.right);

    }

    private int heightOfTree(TreeNode a) {
        if(a == null)
            return 1;
        int l= heightOfTree(a.left);
        int r =heightOfTree(a.right);
        if(l > r)
            return l+1;
        else return r+1;
    }
}
