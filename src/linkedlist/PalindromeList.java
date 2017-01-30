package linkedlist;

public class PalindromeList {
    public static void main(String[] args) {
        ListNode a = ReverseLinkedList.getList();
        ListNode.printNode(a);
        PalindromeList palindromeList = new PalindromeList();
        System.out.println(palindromeList.lPalin(a));
    }

    public int lPalin(ListNode singlePointer) {
        ListNode slow=singlePointer;
        ListNode fastPointer= singlePointer;
        while (fastPointer != null && fastPointer.next != null){
            slow = slow.next;
            fastPointer = fastPointer.next.next;
        }
        ListNode reverseList= getReverseListFromMid(slow);
        slow = singlePointer;
        while (slow != null && reverseList!= null){
            if(slow.val != reverseList.val) return 0;
            slow = slow.next;
            reverseList = reverseList.next;
        }
        return 1;
    }


    private ListNode getReverseListFromMid(ListNode singlePointer) {
        ListNode current = singlePointer;
        ListNode prev = null;
        while (current != null){
            ListNode next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
        }

        return prev;
    }
}
