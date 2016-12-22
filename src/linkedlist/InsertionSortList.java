package linkedlist;
public class InsertionSortList {
    public static void main(String[] args) {
        int[] temp = {54,26,93,17,77,31,44,55,20};
        ListNode a = ListNode.getListFromArray(temp);
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode listNode = insertionSortList.insertionSortList(a);
        ListNode.printNode(listNode);
    }

    private ListNode insertionSortList(ListNode a) {
        ListNode temp = a;
        ListNode prev = temp;
        ListNode beforeNode = a;
        while (temp != null &&temp.next != null){
            if(temp.val > temp.next.val){
                ListNode traverse = temp.next;
                ListNode swapNode = temp;
                while (traverse != null && traverse.val < swapNode.val) {
                    prev = traverse;
                    traverse = traverse.next;
                }
                temp = temp.next;
                ListNode next = prev.next;
                prev.next = swapNode;
                beforeNode.next = temp;
                swapNode.next = next;
            }else {
                beforeNode = temp;
                temp = temp.next;
            }
        }
        return beforeNode;
    }
}
