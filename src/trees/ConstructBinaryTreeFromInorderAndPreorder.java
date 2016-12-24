package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rachana Rao on 12/24/2016.
 */
public class ConstructBinaryTreeFromInorderAndPreorder {
    int preOrderPos = 0;
    Map<Integer, Integer> map;
    public static void main(String[] args) {
ConstructBinaryTreeFromInorderAndPreorder constructBinaryTreeFromInorderAndPreorder = new ConstructBinaryTreeFromInorderAndPreorder();
        Integer[] inorder1 = {4,5,6,10,14,15,16,20,24,25,26,30,34,35,36};
        Integer[] preOrder1 = {20,10,5,4,6,15,14,16,30,25,24,26,35,34,36};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(inorder1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(preOrder1));
        TreeNode treeNode = constructBinaryTreeFromInorderAndPreorder.constrcutTree(b, a);
        TreeNode.printLevelOrderTraversalOfTree(treeNode);
    }

    private TreeNode constrcutTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        map = getValuesInMap(inorder);
        return rec(inorder,preorder,0,(preorder.size()-1));
    }

    private TreeNode rec(ArrayList<Integer> inorder, ArrayList<Integer> preorder, int start, int end) {
        if(start > end || preOrderPos >preorder.size()-1)
            return null;
        int currentVal = preorder.get(preOrderPos++);
        TreeNode treeNode = new TreeNode(currentVal);
      //  int index = inorder.indexOf(currentVal);
        int index = map.get(currentVal);
        treeNode.left =rec(inorder,preorder,start,(index-1));
        treeNode.right = rec(inorder,preorder,(index+1),end);
        return treeNode;
    }

    private Map<Integer, Integer> getValuesInMap(ArrayList<Integer> inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }
        return map;
    }
}
