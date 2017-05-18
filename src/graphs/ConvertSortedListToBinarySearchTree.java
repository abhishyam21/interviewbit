package graphs;

import linkedlist.ListNode;
import trees.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rachana Rao on 5/18/2017.
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ConvertSortedListToBinarySearchTree tree = new ConvertSortedListToBinarySearchTree();
        TreeNode node = tree.sortedListToBST(head);
        TreeNode.printIOrder(node);
        System.out.println();
    }

    private TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = getListElementsAsList(head);
        return convert(list, 0, list.size());
    }

    private TreeNode convert(List<Integer> list, int l, int r) {
        if (l >= r) {
            return null;
        } else {
            int mid = (l + r) / 2;
            TreeNode node = new TreeNode(list.get(mid));
            node.left = convert(list, l, mid);
            node.right = convert(list, mid + 1, r);
            return node;
        }
    }

    private List<Integer> getListElementsAsList(ListNode head) {
        List<Integer> list = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        return list;
    }
}
