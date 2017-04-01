package trees;

import java.util.*;

/**
 * Created by Rachana Rao on 3/30/2017.
 */
public class VerticalOrderTraversalOfBinaryTree {
    public static void main(String[] args) {
       // int[] temp =  {15, 10, 20, 8, 12, 6, 11, 17, 25, 16, 27};
        //int[] temp = {810,2510,1000,1200};
        /*int[] temp = {6,5,4,3,2,1};
        TreeNode a = TreeNode.getTreeNode(temp);*/
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(7);
        a.right.left.right = new TreeNode(8);
        a.right.right.right = new TreeNode(9);
        a.right.right.left= new TreeNode(10);
        a.right.right.left.right= new TreeNode(11);
        a.right.right.left.right.right= new TreeNode(12);
        VerticalOrderTraversalOfBinaryTree binaryTree = new VerticalOrderTraversalOfBinaryTree();
        ArrayList<ArrayList<Integer>> result = binaryTree.verticalOrderTraversal(a);
        result.forEach( node -> System.out.println(node.toString()));
    }

    private ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(a,0));
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
        ArrayList<Integer> ar ;
        while (!queue.isEmpty()){
            Pair peek = queue.poll();
            int val = peek.node.val;
            int level = peek.level;
            if(map.containsKey(level)){
                ar = map.get(level);
            }else
                ar = new ArrayList<>();
            ar.add(val);
            map.put(level,ar);
                if(peek.node.left != null)
                    queue.add(new Pair(peek.node.left,level-1));
                if(peek.node.right != null)
                    queue.add(new Pair(peek.node.right,level+1));
            }
        for (Map.Entry<Integer, ArrayList<Integer>> entity : map.entrySet()) {
           result.add(entity.getValue());
        }

        return result;
    }

    private static class Pair{
        TreeNode node;
        int level;

        public Pair(TreeNode node, int x) {
            this.node = node;
            this.level = x;
        }
    }

/*
    private ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode a) {
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>((num1,num2) -> Integer.compare(num2,num1));
        //Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        util(map,a,0);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entity : map.entrySet()) {
            result.add(entity.getValue());
            System.out.println(entity.getKey()+"--->"+entity.getValue());
        }
        return result;
    }
*/

    /*private void util(Map<Integer, ArrayList<Integer>> result, TreeNode a, int level) {
        if(a == null) return;
        ArrayList<Integer> list = result.get(level);
        if(list == null) list = new ArrayList<>();
        list.add(a.val);
        result.put(level,list);
        util(result,a.left,1+level);
        util(result,a.right,level-1);
    }*/
}
