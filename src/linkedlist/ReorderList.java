package linkedlist;

import java.util.Stack;

public class ReorderList {
    public static void main(String[] args) {
        int[] temp = {1,2,3};
        ListNode a = ListNode.getListFromArray(temp);
        ReorderList reorderList = new ReorderList();
        ListNode listNode = reorderList.reorderList(a);
        ListNode.printNode(listNode);
    }

    private ListNode reorderList(ListNode a) {
        Stack<ListNode> stack = new Stack<>();
        ListNode doubleNode = a;
        ListNode singlePointer = a;
        while (doubleNode != null && doubleNode.next != null){
            doubleNode = doubleNode.next.next;
            singlePointer = singlePointer.next;
        }
        singlePointer = doubleNode!=null ? singlePointer.next: singlePointer;
        while (singlePointer != null){
            stack.push(singlePointer);
            singlePointer = singlePointer.next;
        }
        ListNode temp = a;
        while (!stack.isEmpty()){
            ListNode lastNode = stack.pop();
            ListNode nexNode = temp.next;
            temp.next = lastNode;
            lastNode.next = nexNode;
            temp = nexNode;
        }
        temp.next = null;
        return a;
    }
}
