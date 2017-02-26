package dynamicProgramming;

import trees.PreOrderTraversal;
import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * for detail explanation
 * http://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
 * Created by Rachana Rao on 2/26/2017.
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        UniqueBinarySearchTreesII searchTreesII = new UniqueBinarySearchTreesII();
        System.out.println(searchTreesII.countTrees(3));
        searchTreesII.generateTrees(3);
    }

    /**
     * This method will just return the count of
     * number of trees we can generate
     * @param a input number
     * @return total number of tree that generated
     */
    private int countTrees(int a) {

        int[] cache= new int[a+1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= a; i++) {
            for (int j = 0; j < i; j++) {
                cache[i]=cache[i]+cache[j]*cache[i-j-1];
            }
        }
        return cache[a];
    }

    private void generateTrees(int a){
        List<TreeNode> TreeNodes = generateTreeUtil(1, a);
        
        for (TreeNode treeNode : TreeNodes) {
            PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
            ArrayList<Integer> list = preOrderTraversal.preorderTraversal(treeNode);
            System.out.println(list.toString());
        }
    }

    private List<TreeNode> generateTreeUtil(int start, int end) {
        List<TreeNode> bstTrees = new ArrayList<>();
        if(start > end){
            bstTrees.add(null);
            return bstTrees;
        }
        if(start == end){
            bstTrees.add(new TreeNode(start));
            return bstTrees;
        }
        List<TreeNode> left;
        List<TreeNode> right;
        for (int i = start; i <= end; i++) {
            left = generateTreeUtil(start, i-1);
            right = generateTreeUtil(i+1,end);

            for (TreeNode leftTree : left) {
                for (TreeNode rightTree : right) {

                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    node.right = rightTree;
                    bstTrees.add(node);
                }
            }
        }
        return bstTrees;
    }
}
