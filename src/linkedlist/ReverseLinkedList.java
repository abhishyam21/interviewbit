package linkedlist;

/**
 * Created by Rachana Rao on 11/12/2016.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode a = getList();
        ListNode.printNode(a);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode listNode = reverseLinkedList.reverseList(a);
        ListNode.printNode(listNode);
    }

    private ListNode reverseList(ListNode a) {
        ListNode prev = null;
        ListNode current = a;
        ListNode next = a;
        while (next != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode getList() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(1);
        a.next.next = new ListNode(6);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(1);
        //a.next.next.next.next.next = new ListNode(2);
       // a.next.next.next.next.next.next = new ListNode(1);
     //   a.next.next.next.next.next.next.next = new ListNode(1);
        return a;
    }
}
