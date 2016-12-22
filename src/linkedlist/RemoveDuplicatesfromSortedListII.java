package linkedlist;

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        ListNode a = ReverseLinkedList.getList();
        ListNode.printNode(a);
        RemoveDuplicatesfromSortedListII removeDuplicatesfromSortedListII = new RemoveDuplicatesfromSortedListII();
        ListNode listNode = removeDuplicatesfromSortedListII.deleteDuplicates(a);
        ListNode.printNode(listNode);
    }

    private ListNode deleteDuplicates(ListNode a) {
        ListNode next = new ListNode(-1);
        next.next = a;
        ListNode prev = next;
        ListNode current = next.next;
        while (current  != null){
            while (current.next != null && (prev.next.val == current.next.val))
                current = current.next;
            if(prev.next ==current){
                prev = prev.next;
            }
            current =current.next;
        }
        ListNode.printNode(next.next);
        return next.next;
    }

}
