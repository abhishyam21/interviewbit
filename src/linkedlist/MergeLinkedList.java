package linkedlist;

public class MergeLinkedList {
    public static void main(String[] args) {
        int[] a1 = {2, 4, 6, 8, 10};
        int[] b1 = {1, 3, 5, 7, 9};
        ListNode a = ListNode.getListFromArray(a1);
        ListNode b = ListNode.getListFromArray(b1);
        MergeLinkedList mergeLinkedList = new MergeLinkedList();
        ListNode result = mergeLinkedList.mergeTwoLists(a, b);
        ListNode.printNode(result);
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode list1 = a;
        ListNode list2 = b;
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        temp.next = list1 != null ? list1 : list2;
        return result.next;
    }

}
