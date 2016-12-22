package trees;

/**
 * Created by abhishyam.c on 12/17/2016.
 */
public class NextGreaterNumberBst {
    public static void main(String[] args) {
        int[] a ={15,10,20,8,12,6,11,17,25,16,27};
        int b = 11;
        TreeNode treeNode = TreeNode.getTreeNode(a);
        TreeNode.printLevelOrderTraversalOfTree(treeNode);
        NextGreaterNumberBst nextGreaterNumberBst = new NextGreaterNumberBst();
        TreeNode successor = nextGreaterNumberBst.getSuccessor(treeNode, b);
        System.out.println(successor.val);
    }



    private TreeNode getSuccessor(TreeNode a, int b) {
        TreeNode temp = a;
        while (temp != null){
            if(temp.val == b){
                    return getNodeVal(temp,b,a);
            }else if(temp.val > b){
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        return null;
    }

    private TreeNode getNodeVal(TreeNode currentNode, int b, TreeNode a) {
        TreeNode temp = currentNode;
        //first check in right side of current node.
        //if right is not null, traverse right left till end
        if(temp.right != null) {
            temp = temp.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }else {//if there is no right sub tree, start from root and keep checking if that ancestors is left one
            temp = a;
            TreeNode ancestors = null;
            while (temp != null ){
                if(temp ==currentNode)
                    return ancestors;
                else if(temp.val > currentNode.val){
                    if(temp.val > currentNode.val)
                        ancestors = temp;
                    temp = temp.left;
                }else {
                    temp = temp.right;
                }
            }
        }
        return null;
    }
}
