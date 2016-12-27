package trees;

import java.util.*;

import static java.util.Collections.reverse;

/**
 * Created by Rachana Rao on 12/25/2016.
 */
public class ZigZagLevelOrderTraversalBt {
    public static void main(String[] args) {
        ZigZagLevelOrderTraversalBt zigZagLevelOrderTraversalBt = new ZigZagLevelOrderTraversalBt();
        int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
        TreeNode a = TreeNode.getTreeNode(temp);
        ArrayList<ArrayList<Integer>> arrayLists = zigZagLevelOrderTraversalBt.zigZagLevelOrderTraversalBt(a);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList.toString());
        }
    }

    public ArrayList<ArrayList<Integer>> zigZagLevelOrderTraversalBt(TreeNode a) {

        boolean counter = false;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(a);
        queue.add(null);
        ArrayList<Integer> row = new ArrayList<>();
        while (queue.size()>1){
            TreeNode node = queue.poll();
            if(node == null) {
                counter =!counter;
                result.add(getRow(row,counter));
                row = new ArrayList<>();
                queue.add(null);
            }
            else {
                row.add(node.val);
                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
            }
        }
       result.add(getRow(row,!counter));
        return result;
    }

    private ArrayList<Integer> getRow(ArrayList<Integer> row, boolean counter) {
        if(!counter)
            reverse(row);
            return row;
        }
}
