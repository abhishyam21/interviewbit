package linkedlist;

import java.util.Stack;

/**
 * Created by Rachana Rao on 1/17/2017.
 */
public class Subtract {
    public static void main(String[] args) {
        int[] temp = {95,2,3,4,5,24};
        ListNode a  = ListNode.getListFromArray(temp);
        Subtract subtract= new Subtract();
        a =subtract.subtract(a);
        ListNode.printNode(a);

    }

    private ListNode subtract(ListNode a) {
        Stack<Integer> stack = new Stack<>();
        ListNode slowNode = a;
        while (slowNode != null){
            stack.push(slowNode.val);
            slowNode = slowNode.next;
        }
        slowNode = a;
        ListNode fast = a;
        while (fast!= null && fast.next != null){
            fast = fast.next.next;
            slowNode.val = (stack.pop()-slowNode.val);
            slowNode =slowNode.next;
        }
        return a;
    }
}
