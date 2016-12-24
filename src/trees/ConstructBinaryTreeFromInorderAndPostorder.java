package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rachana Rao on 12/24/2016.
 */
public class ConstructBinaryTreeFromInorderAndPostorder {
    int postOrderPos = 0;
    Map<Integer, Integer> map;

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorder constructBinaryTreeFromInorderAndPostorder = new ConstructBinaryTreeFromInorderAndPostorder();
        Integer[] inorder1 = {4, 5, 6, 10, 14, 15, 16, 20, 24, 25, 26, 30, 34, 35, 36};
        Integer[] preOrder1 = {4, 6, 5, 14, 16, 15, 10, 24, 26, 25, 34, 36, 35, 30, 20};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(inorder1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(preOrder1));
        TreeNode treeNode = constructBinaryTreeFromInorderAndPostorder.constrcutTree(a, b);
        TreeNode.printLevelOrderTraversalOfTree(treeNode);
    }

    private TreeNode constrcutTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        postOrderPos = inorder.size() - 1;
        map = getValuesInMap(inorder);
        return recu(inorder, postorder, 0, (inorder.size() - 1));
    }

    private Map<Integer, Integer> getValuesInMap(ArrayList<Integer> inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }
        return map;
    }

    private TreeNode recu(ArrayList<Integer> inorder, ArrayList<Integer> postOrder, int start, int end) {
        if (start > end)
            return null;
        int currentVal = postOrder.get(postOrderPos--);
        TreeNode treeNode = new TreeNode(currentVal);
        //int index = inorder.indexOf(currentVal);
        int index = map.get(currentVal);
        treeNode.right = recu(inorder, postOrder, (index + 1), end);
        treeNode.left = recu(inorder, postOrder, start, (index - 1));
        return treeNode;
    }
}
