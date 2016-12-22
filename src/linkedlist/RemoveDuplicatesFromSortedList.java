package linkedlist;
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
            ListNode a = ReverseLinkedList.getList();
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode listNode = removeDuplicatesFromSortedList.deleteDuplicates(a);
        ListNode.printNode(listNode);
    }

    private ListNode deleteDuplicates(ListNode a) {
        ListNode temp = new ListNode(-1);
        temp.next = a;
        ListNode prev = temp;
        temp = temp.next;
        while (temp != null){
            if(temp.val == prev.val)
                prev.next = temp.next;
            else
            prev = temp;
            temp = temp.next;
        }
        return a;
    }
}
